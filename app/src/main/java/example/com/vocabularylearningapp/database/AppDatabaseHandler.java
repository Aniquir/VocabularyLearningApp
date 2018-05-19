package example.com.vocabularylearningapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "databaseOfWords";

    public AppDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE words" +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstTranslation TEXT, " +
                "secondTranslation TEXT, " +
                "assignmentNumber INTEGER) ";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS wrods";
        db.execSQL(sql);

        onCreate(db);
    }
}
