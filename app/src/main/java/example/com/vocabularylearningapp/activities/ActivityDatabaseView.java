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

import java.util.List;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;
import example.com.vocabularylearningapp.onClickListeners.OnLongClickListenerWordRecord;


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

        List<ObjectWord> words = new TableControllerWord(this).read(numNeededToDisplayCorrectDb);

        if (words.size() > 0) {

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
                textViewWordItem.setOnLongClickListener(new OnLongClickListenerWordRecord());

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
}