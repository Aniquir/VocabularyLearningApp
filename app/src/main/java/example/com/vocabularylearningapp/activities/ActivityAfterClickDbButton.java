package example.com.vocabularylearningapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.vocabularylearningapp.R;

public class ActivityAfterClickDbButton extends AppCompatActivity {

    private static final String NEW_WORD_DB = "newWord";
    private static final String REPEAT_WORD_DB = "repeatWord";
    private static final String KNOWN_WORD_DB = "knownWord";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_db_button);

        Button newWordButton = findViewById(R.id.dbNewWords);
        newWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tu jest problem
            whenDBIsEmpty(checkDB(NEW_WORD_DB, ActivityAfterClickDbButton.NEW_WORD_DB));
            }
        });

        Button repeatWordButton = findViewById(R.id.dbRepeatWords);
        repeatWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button knownWordButton = findViewById(R.id.dbKnownWords);
        knownWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    // i tu
    public boolean checkDB(String nameOfDatabase, SQLiteDatabase db){

        boolean checkRows;

        @SuppressLint("Recycle")
        Cursor mCursor = db.rawQuery("SELECT * FROM " + nameOfDatabase, null);

        checkRows = mCursor.moveToFirst();
        return checkRows;
    }

    public void whenDBIsEmpty(boolean b){

        if (!b){
            Intent myIntent = new Intent(ActivityAfterClickDbButton.this,
                    AcitvityAfterClickSomeDatabaseWhenItIsEmpty.class);
            startActivity(myIntent);
        }

    }
}
