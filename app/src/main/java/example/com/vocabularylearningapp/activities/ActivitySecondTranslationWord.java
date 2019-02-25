package example.com.vocabularylearningapp.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;

public class ActivitySecondTranslationWord extends AppCompatActivity {

    Context context;
    ObjectWord objectWord = ActivityFirstTranslationWord.objectWord;
    int assignmentNumberOfWord;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_translation);

        ImageButton backToMainMenuButton = findViewById(R.id.imageButtonBackToMainMenu);
        backToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntenet = new Intent(ActivitySecondTranslationWord.this,
                        MainActivity.class);
                startActivity(myIntenet);
                finish();
            }
        });

        TextView textViewSecTranslation = findViewById(R.id.textViewSecondTranslation);
        textViewSecTranslation.setText(ActivityFirstTranslationWord.objectWordSecondTranslation);

        TextView countOfLearWordSecTranslation = findViewById(R.id.counterOfLearningWordsTextViewSecondTranslation);
        countOfLearWordSecTranslation.setText(ActivityFirstTranslationWord.currentNumberOfWordCounter
                + " / "
                + ActivityAfterClickStartButton.numberOfWordsInTheSet);

        Button putInRepeatWordsButton = findViewById(R.id.putInRepeatWordsButton);
        putInRepeatWordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = v.getContext();
                assignmentNumberOfWord = 1;
                transferToOtherDatabase();
            }
        });

        Button putInKnownWordsButton = findViewById(R.id.putInKnownWordsButton);
        putInKnownWordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = v.getContext();
                assignmentNumberOfWord = 2;
                transferToOtherDatabase();
            }
        });
    }

    private void transferToOtherDatabase() {
        boolean transferToOtherDatabase = new TableControllerWord(context).updateByChangeAssignmentNumber(objectWord, assignmentNumberOfWord);

        if (transferToOtherDatabase) {
            ActivityFirstTranslationWord.currentNumberOfWordCounter++;
            Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Unable to transfer the word", Toast.LENGTH_SHORT).show();
        }

        if (ActivityFirstTranslationWord.currentNumberOfWordCounter > ActivityAfterClickStartButton.numberOfWordsInTheSet) {
            Intent myIntenet = new Intent(ActivitySecondTranslationWord.this,
                    ActivityAfterClickStartButton.class);
            startActivity(myIntenet);
            finish();
        } else {
            Intent myIntenet = new Intent(ActivitySecondTranslationWord.this,
                    ActivityFirstTranslationWord.class);
            startActivity(myIntenet);
            finish();
        }
    }
}
