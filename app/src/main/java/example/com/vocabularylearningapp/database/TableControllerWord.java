package example.com.vocabularylearningapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import example.com.vocabularylearningapp.entity.ObjectWord;

public class TableControllerWord extends AppDatabaseHandler{


    public TableControllerWord(Context context) {
        super(context);
    }

    public boolean create(ObjectWord objectWord){

        ContentValues values = new ContentValues();

        values.put("firstTranslation", objectWord.getFirstTranslation());
        values.put("secondTranslation", objectWord.getSecondTranslation());
        values.put("assignmentNumber", objectWord.getAssignmentNumber());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("words", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public int count(){

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM words";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;
    }

    public List<ObjectWord> read(int i){

        List<ObjectWord> recordList = new ArrayList<>();

        String sql = "SELECT * FROM words WHERE assignmentNumber LIKE " + i;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String firstTranslation = cursor.getString(cursor.getColumnIndex("first_translation"));
                String secondTranslation = cursor.getString(cursor.getColumnIndex("second_translation"));
                int assignmentNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex("assignment_number")));

                ObjectWord objectWord = new ObjectWord();
                objectWord.setId(id);
                objectWord.setFirstTranslation(firstTranslation);
                objectWord.setSecondTranslation(secondTranslation);
                objectWord.setAssignmentNumber(assignmentNumber);

                recordList.add(objectWord);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordList;
    }

    public ObjectWord readSingleRecord(int wordId){

        ObjectWord objectWord = null;

        String sql = "SELECT * FROM words WHERE id = " + wordId;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String firstTranslation = cursor.getString(cursor.getColumnIndex("first_translation"));
            String secondTranslation = cursor.getString(cursor.getColumnIndex("second_translation"));
            int assignmentNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex("assignment_number")));

            objectWord = new ObjectWord();
            objectWord.setId(id);
            objectWord.setFirstTranslation(firstTranslation);
            objectWord.setSecondTranslation(secondTranslation);
            objectWord.setAssignmentNumber(assignmentNumber);
        }

        cursor.close();
        db.close();

        return objectWord;
    }

    public boolean update(ObjectWord objectWord){

        ContentValues values = new ContentValues();

        values.put("firstTranslation", objectWord.getFirstTranslation());
        values.put("secondTranslation", objectWord.getSecondTranslation());

        String where = "id = ?";

        String[] whereArgs = { Integer.toString(objectWord.getId()) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful = db.update("words", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;
    }

    public boolean delete(int id){

        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();
        deleteSuccessful = db.delete("words", "id ='" + id + "'", null) > 0;
        db.close();

        return deleteSuccessful;
    }
}
