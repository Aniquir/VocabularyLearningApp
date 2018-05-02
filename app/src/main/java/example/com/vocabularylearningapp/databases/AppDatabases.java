package example.com.vocabularylearningapp.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import example.com.vocabularylearningapp.entity.ObjectWord;
import example.com.vocabularylearningapp.entity.ObjectWordDAO;

import static example.com.vocabularylearningapp.databases.AppDatabases.DATABASE_VERSION;

@Database(entities = {ObjectWord.class}, version = DATABASE_VERSION)
public abstract class AppDatabases extends RoomDatabase{

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NEW_WORD_NAME = "newWord";
    public static final String DATABASE_REPEAT_WORD_NAME = "repeatWord";
    public static final String DATABASE_KNOWN_WORD_NAME = "knownWord";

    public abstract ObjectWordDAO objectWordDAO();

    private static AppDatabases mInstanceNewWord;
    private static AppDatabases mInstanceRepeatWord;
    private static AppDatabases mInstanceKnownWord;

    public static AppDatabases getInstanceNewWord(Context context){

        if(mInstanceNewWord == null){
            mInstanceNewWord = Room.databaseBuilder(context, AppDatabases.class, DATABASE_NEW_WORD_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstanceNewWord;
    }
    public static AppDatabases getInstanceRepeatWord(Context context){

        if(mInstanceRepeatWord == null){
            mInstanceRepeatWord = Room.databaseBuilder(context, AppDatabases.class, DATABASE_REPEAT_WORD_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstanceRepeatWord;
    }
    public static AppDatabases getInstanceKnownWord(Context context){

        if(mInstanceKnownWord == null){
            mInstanceKnownWord = Room.databaseBuilder(context, AppDatabases.class, DATABASE_KNOWN_WORD_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstanceKnownWord;
    }
}
