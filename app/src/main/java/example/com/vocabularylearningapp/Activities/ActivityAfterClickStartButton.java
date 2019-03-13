package example.com.vocabularylearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;

public class ActivityAfterClickStartButton extends AppCompatActivity {

    public static int numberOfWordsInTheSet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_start_button);
        ActivityFirstTranslationWord.currentNumberOfWordCounter = 1;

        ImageButton backToMainMenuButton = findViewById(R.id.imageButtonBackToMainMenu);
        backToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntenet = new Intent(ActivityAfterClickStartButton.this,
                        MainActivity.class);
                startActivity(myIntenet);
                finish();
            }
        });

        Button newWordButton = findViewById(R.id.start1NewWords);
        newWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWordsInTheSet = 10;
                ActivityAfterClickDbButton.numNeededToDisplayCorrectDb = 0;
                int currentNumberOfSelectedWords = counterOfSelectedWords(0);
                if (counterOfSelectedWords(0) < 10){
                    numberOfWordsInTheSet = currentNumberOfSelectedWords;
                }
                startFirstTranslationWordView();
            }
        });

        Button repeatWordButton = findViewById(R.id.start1RepeatWords);
        repeatWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWordsInTheSet = 5;
                ActivityAfterClickDbButton.numNeededToDisplayCorrectDb = 1;
                int currentNumberOfSelectedWords = counterOfSelectedWords(1);
                if (counterOfSelectedWords(1) < 5){
                    numberOfWordsInTheSet = currentNumberOfSelectedWords;
                }
                startFirstTranslationWordView();
            }
        });

        Button knownWordButton = findViewById(R.id.start1KnownWords);
        knownWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWordsInTheSet = 5;
                ActivityAfterClickDbButton.numNeededToDisplayCorrectDb = 2;
                int currentNumberOfSelectedWords = counterOfSelectedWords(2);
                if (counterOfSelectedWords(2) < 5){
                    numberOfWordsInTheSet = currentNumberOfSelectedWords;
                }
                startFirstTranslationWordView();
            }
        });
    }

    private void startFirstTranslationWordView() {
        Intent myIntenet = new Intent(ActivityAfterClickStartButton.this,
                ActivityFirstTranslationWord.class);
        startActivity(myIntenet);
        finish();
    }

    public int counterOfSelectedWords(int markWordInDb){
        List<ObjectWord> words = new TableControllerWord(this).read(markWordInDb);
        int counter = 0;
        for (int i = 0; i < words.size(); i++) {
            counter++;
        }
        return counter;
    }
}
