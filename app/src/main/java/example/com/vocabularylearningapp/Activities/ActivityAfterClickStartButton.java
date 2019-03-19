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
import example.com.vocabularylearningapp.helpers.AssignmentNumberCorrector;
import example.com.vocabularylearningapp.helpers.WordCounter;

public class ActivityAfterClickStartButton extends AppCompatActivity {

    public static int numberOfWordsInTheSet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_start_button);
        ActivityFirstTranslationWord.currentNumberOfWordCounter = 1;

        updateToCorrectAssignmentNumbersOfWords();

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
                int currentNumberOfSelectedWords = getNumberOfSelectedWords(0);
                if (getNumberOfSelectedWords(0) < 10) {
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
                int currentNumberOfSelectedWords = getNumberOfSelectedWords(1);
                if (getNumberOfSelectedWords(1) < 5) {
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
                int currentNumberOfSelectedWords = getNumberOfSelectedWords(2);
                if (getNumberOfSelectedWords(2) < 5) {
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

    public int getNumberOfSelectedWords(int markWordInDb) {
        List<ObjectWord> words = new TableControllerWord(this).read(markWordInDb);
        WordCounter wordCounter = new WordCounter();
        return wordCounter.counterOfSelectedWords(words);
    }

    public void updateToCorrectAssignmentNumbersOfWords(){
        TableControllerWord tableControllerWord = new TableControllerWord(getApplicationContext());
        List<ObjectWord> wordsToUpdate = new TableControllerWord(getApplicationContext()).readAll();
        AssignmentNumberCorrector assignmentNumberCorrector = new AssignmentNumberCorrector();

        assignmentNumberCorrector.updateToCorrectAssignmentNumbersOfWords(tableControllerWord, wordsToUpdate);
    }
}
