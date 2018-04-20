package example.com.vocabularylearningapp.activities;

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
//            whenDBIsEmpty(checkDB(NEW_WORD_DB, db));
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

//    public boolean checkDB(String nameOfDatabase, SQLiteDatabase db){
//
//        boolean check = false;
//
//        @SuppressLint("Recycle")
//        Cursor mCursor = db.rawQuery("SELECT * FROM " + nameOfDatabase, null);
//
//        if (mCursor.moveToFirst()) {
//            check = true;
//
//        } else {
//            check = false;
//        }
//        return check;
//    }
//
//    public void whenDBIsEmpty(boolean b){
//
//        if (!b){
//            Intent myIntent = new Intent(ActivityAfterClickDbButton.this,
//                    AcitvityAfterClickSomeDatabaseWhenItIsEmpty.class);
//            startActivity(myIntent);
//        }
//
//    }
}
