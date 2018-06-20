package example.com.vocabularylearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.vocabularylearningapp.R;

public class ActivityAfterClickStartButton extends AppCompatActivity {

    public static int numberOfWordsInTheSet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_start_button);

        Button newWordButton = findViewById(R.id.start1NewWords);
        newWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWordsInTheSet = 10;
                ActivityAfterClickDbButton.numNeededToDisplayCorrectDb = 0;
                Intent myIntenet = new Intent(ActivityAfterClickStartButton.this,
                        ActivityFirstTranslationWord.class);
                startActivity(myIntenet);
            }
        });

        Button repeatWordButton = findViewById(R.id.start1RepeatWords);
        repeatWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWordsInTheSet = 5;
                ActivityAfterClickDbButton.numNeededToDisplayCorrectDb = 1;
                Intent myIntenet = new Intent(ActivityAfterClickStartButton.this,
                        ActivityFirstTranslationWord.class);
                startActivity(myIntenet);
            }
        });

        Button knownWordButton = findViewById(R.id.start1KnownWords);
        knownWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWordsInTheSet = 5;
                ActivityAfterClickDbButton.numNeededToDisplayCorrectDb = 2;
                Intent myIntenet = new Intent(ActivityAfterClickStartButton.this,
                        ActivityFirstTranslationWord.class);
                startActivity(myIntenet);
            }
        });
    }
//    public void loopOfActivityToViewWordsAndSetValueInTheCounter(int countOfWords){
//
//        numberOfWordsInTheSet = countOfWords;
//        for (int i = 0; i < countOfWords; i++) {
//            numberOfWordsToView = i + 1;
//
//        }
//    }
}
