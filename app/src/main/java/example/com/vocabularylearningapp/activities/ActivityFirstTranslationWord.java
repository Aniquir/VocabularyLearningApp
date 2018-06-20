package example.com.vocabularylearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;

public class ActivityFirstTranslationWord extends AppCompatActivity {

    public static String objectWordFirstTranslation;
    public static String objectWordSecondTranslation;
    public static ObjectWord objectWord = new ObjectWord();
    public static int currentNumberOfWordCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_translation);

        ImageButton backToMainMenuButton = findViewById(R.id.imageButtonBackToMainMenu);
        backToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntenet = new Intent(ActivityFirstTranslationWord.this,
                        MainActivity.class);
                startActivity(myIntenet);
            }
        });

        TextView textView = findViewById(R.id.counterOfLearningWordsTextViewFirstTranslation);
        textView.setText(currentNumberOfWordCounter
                            + " / "
                            + ActivityAfterClickStartButton.numberOfWordsInTheSet);

        //method reads word from correct database
        readWord(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);

        Button nextButton = findViewById(R.id.buttonToGoNextFirstTranslation);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntenet = new Intent(ActivityFirstTranslationWord.this,
                        ActivitySecondTranslationWord.class);
                startActivity(myIntenet);
            }
        });
    }

    private void readWord(int numNeededToDisplayCorrectDb) {

        if (numNeededToDisplayCorrectDb == 0) {

            readFirstAndSecondTranslation(numNeededToDisplayCorrectDb);

        } else if (numNeededToDisplayCorrectDb == 1) {

            readFirstAndSecondTranslation(numNeededToDisplayCorrectDb);

        } else {

            readFirstAndSecondTranslation(numNeededToDisplayCorrectDb);
        }
    }

    public void readFirstAndSecondTranslation(int numNeededToDisplayCorrectDb) {
        TextView textViewFirstTranslation = findViewById(R.id.textViewFirstTranslation);
//        TextView textViewSecondTranslation = findViewById(R.id.textViewSecondTranslation);


        List<ObjectWord> words = new TableControllerWord(this).read(numNeededToDisplayCorrectDb);

        if (words.size() > 0) {
            ArrayList<Integer> ids = new ArrayList<>();
            for (ObjectWord word : words) {
                int id = word.getId();
                ids.add(id);
            }
            int index = new Random().nextInt(ids.size());
            int randomIdOfWord = ids.get(index);
            objectWord = new TableControllerWord(this).readSingleRecord(randomIdOfWord);
            objectWordFirstTranslation = objectWord.getFirstTranslation();
            objectWordSecondTranslation = objectWord.getSecondTranslation();

            textViewFirstTranslation.setText(objectWordFirstTranslation);
        } else {
            textViewFirstTranslation.setText("No records yet.");
        }
    }

}
