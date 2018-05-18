package example.com.vocabularylearningapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.AppDatabase;

public class ActivityAfterClickDbButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_db_button);

        Button newWordButton = findViewById(R.id.buttonDbNewWords);
        newWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                doesDBExist(context, AppDatabase.DATABASE_OF_WORDS);
// teraz tutaj dalsza czesc, obsluga db, wyswietlenie itd, ale najpierwsz, trzeba zrobic,
// zeby mozna bylo dodawac do bazy dancy, tylko do tej z nowymi slowami
            }
        });

        Button repeatWordButton = findViewById(R.id.buttonDbRepeatWords);
        repeatWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                doesDBExist(context, AppDatabase.DATABASE_OF_WORDS);
            }
        });

        Button knownWordButton = findViewById(R.id.buttonDbKnownWords);
        knownWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                doesDBExist(context, AppDatabase.DATABASE_OF_WORDS);
            }
        });
    }

    private void doesDBExist(Context context, String dbName) {
        boolean checkRows;

        File dbFile = context.getDatabasePath(dbName);
        checkRows = dbFile.exists();

        if (!checkRows) {
            Intent myIntent = new Intent(ActivityAfterClickDbButton.this,
                    AcitvityAfterClickDatabaseWhenItIsEmpty.class);
            startActivity(myIntent);
        }
    }

}
