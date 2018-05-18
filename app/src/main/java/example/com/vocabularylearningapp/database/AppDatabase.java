package example.com.vocabularylearningapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import example.com.vocabularylearningapp.entity.ObjectWord;
import example.com.vocabularylearningapp.entity.ObjectWordDAO;

import static example.com.vocabularylearningapp.database.AppDatabase.DATABASE_VERSION;

@Database(entities = {ObjectWord.class}, version = DATABASE_VERSION)
public abstract class AppDatabase extends RoomDatabase {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_OF_WORDS = "databaseOfWords";

    public abstract ObjectWordDAO objectWordDAO();

    private static AppDatabase mInstanceDatabaseOfWords;

    public static AppDatabase getInstanceDatabaseOfWords(Context context) {

        if (mInstanceDatabaseOfWords == null) {
            mInstanceDatabaseOfWords = Room.databaseBuilder(context, AppDatabase.class, DATABASE_OF_WORDS)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstanceDatabaseOfWords;
    }
}
