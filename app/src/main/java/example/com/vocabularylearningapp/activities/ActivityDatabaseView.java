package example.com.vocabularylearningapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;
import example.com.vocabularylearningapp.onClickListeners.OnLongClickListenerWordRecordFragment;


public class ActivityDatabaseView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_view);
        countRecords(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);
        readRecords(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);

        ImageButton backToMainMenuButton = findViewById(R.id.imageButtonBackToMainMenu);
        backToMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntenet = new Intent(ActivityDatabaseView.this,
                        MainActivity.class);
                startActivity(myIntenet);
                finish();
            }
        });

        ImageButton backToPreviousActivityButton = findViewById(R.id.imageButtonBackToPreviousActivity);
        backToPreviousActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ActivityDatabaseView.this, ActivityAfterClickDbButton.class);
                startActivity(myIntent);
                finish();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void countRecords(int numNeededToDisplayCorrectDb) {

        int recordCount = new TableControllerWord(this).count(numNeededToDisplayCorrectDb);
        TextView textViewRecordCount = findViewById(R.id.counterOfWordsInDatabase);
        if (recordCount == 1){
            textViewRecordCount.setText(recordCount + " word");
        } else {
            textViewRecordCount.setText(recordCount + " words");
        }
    }

    @SuppressLint("SetTextI18n")
    public void readRecords(int numNeededToDisplayCorrectDb) {

        LinearLayout linearLayoutRecords = findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<ObjectWord> words = new TableControllerWord(this).readWithAssignmentNumber(numNeededToDisplayCorrectDb);

        if (words.size() > 0) {

            sortListAlphabetically(words);

            for (ObjectWord word : words) {
                int id = word.getId();
                String firstTranslation = word.getFirstTranslation();
                String secondTranslation = word.getSecondTranslation();
                String textViewContents = firstTranslation + " - " + secondTranslation;

                TextView textViewWordItem = new TextView(this);
                textViewWordItem.setTextSize(20);
                textViewWordItem.setTypeface(null, Typeface.BOLD);
                textViewWordItem.setGravity(Gravity.CENTER_HORIZONTAL);
                textViewWordItem.setPadding(0, 10, 0, 10);
                textViewWordItem.setTextColor(this.getResources().getColor(R.color.halfTransparentBlue));
                textViewWordItem.setText(textViewContents);
                textViewWordItem.setTag(Integer.toString(id));
                textViewWordItem.setOnLongClickListener(new OnLongClickListenerWordRecordFragment());

                linearLayoutRecords.addView(textViewWordItem);
            }
        } else {

            TextView locationItem = new TextView(this);
            locationItem.setTypeface(null, Typeface.BOLD);
            locationItem.setTextSize(24);
            locationItem.setGravity(Gravity.CENTER_HORIZONTAL);
            locationItem.setPadding(8, 80, 8, 8);
            locationItem.setTextColor(this.getResources().getColor(R.color.halfTransparentBlue));
            locationItem.setText(getString(R.string.no_records_yet));

            linearLayoutRecords.addView(locationItem);
        }
    }

    private void sortListAlphabetically(List<ObjectWord> words) {
        Collections.sort(words, new Comparator<ObjectWord>() {
            @Override
            public int compare(ObjectWord o1, ObjectWord o2) {
                return o1.getFirstTranslation().compareToIgnoreCase(o2.getFirstTranslation());
            }
        });
    }
}