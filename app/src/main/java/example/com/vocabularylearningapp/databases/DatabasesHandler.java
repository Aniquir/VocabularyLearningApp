package example.com.vocabularylearningapp.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabasesHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "WordDatabase";

    public DatabasesHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE newWord " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstTranslation TEXT, " +
                "secondTranslation TEXT ) ";

        String sql1 = "CREATE TABLE repeatWord " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstTranslation TEXT, " +
                "secondTranslation TEXT ) ";

        String sql2 = "CREATE TABLE knownWord " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstTranslation TEXT, " +
                "secondTranslation TEXT ) ";

        db.execSQL(sql);
        db.execSQL(sql1);
        db.execSQL(sql2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nothing to do
    }
}
