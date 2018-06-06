package example.com.vocabularylearningapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;


public class ActivityDatabaseView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_view);
        countRecords(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);
        readRecords(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);
    }


    public void countRecords(int numNeededToDisplayCorrectDb) {

        int recordCount = new TableControllerWord(this).count(numNeededToDisplayCorrectDb);
        TextView textViewRecordCount = findViewById(R.id.counterOfWordsInDatabase);
        textViewRecordCount.setText(recordCount + " words found");

    }

    public void readRecords(int numNeededToDisplayCorrectDb) {

        LinearLayout linearLayoutRecords = findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<ObjectWord> words = new TableControllerWord(this).read(numNeededToDisplayCorrectDb);

        if (words.size() > 0) {

            for (ObjectWord word : words) {
                int id = word.getId();
                String firstTranslation = word.getFirstTranslation();
                String secondTranslation = word.getSecondTranslation();
                //here change view of db
                String textViewContents = firstTranslation + " - " + secondTranslation;

                TextView textViewWordItem = new TextView(this);
                textViewWordItem.setPadding(0, 10, 0, 10);
                textViewWordItem.setText(textViewContents);
                textViewWordItem.setTag(Integer.toString(id));
                textViewWordItem.setOnLongClickListener(new OnLongClickListenerWordRecord());

                linearLayoutRecords.addView(textViewWordItem);
            }
        } else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            linearLayoutRecords.addView(locationItem);
        }
    }
}