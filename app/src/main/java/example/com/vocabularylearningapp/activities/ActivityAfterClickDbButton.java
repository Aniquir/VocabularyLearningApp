package example.com.vocabularylearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.vocabularylearningapp.R;

public class ActivityAfterClickDbButton extends AppCompatActivity {

    public static int numNeededToDisplayCorrectDb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_db_button);

        Button newWordButton = findViewById(R.id.buttonDbNewWords);
        newWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numNeededToDisplayCorrectDb = 0;
                Intent myIntenet = new Intent(ActivityAfterClickDbButton.this,
                        ActivityDatabaseView.class);
                startActivity(myIntenet);
            }
        });

        Button repeatWordButton = findViewById(R.id.buttonDbRepeatWords);
        repeatWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numNeededToDisplayCorrectDb = 1;
                Intent myIntenet = new Intent(ActivityAfterClickDbButton.this,
                        ActivityDatabaseView.class);
                startActivity(myIntenet);
            }
        });

        Button knownWordButton = findViewById(R.id.buttonDbKnownWords);
        knownWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numNeededToDisplayCorrectDb = 2;
                Intent myIntenet = new Intent(ActivityAfterClickDbButton.this,
                        ActivityDatabaseView.class);
                startActivity(myIntenet);
            }
        });
    }


}
