package example.com.vocabularylearningapp.activities;

import android.annotation.SuppressLint;
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
        countRecords();
        readRecords();
    }

    @SuppressLint("SetTextI18n")
    public void countRecords() {

        int recordCount = new TableControllerWord(this).count();
        TextView textViewRecordCount = findViewById(R.id.counterOfWordsInDatabase);
        textViewRecordCount.setText(recordCount + " words found");

    }

    public void readRecords() {

        LinearLayout linearLayoutRecords = findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();
        // ~
        ObjectWord objectWord = new ObjectWord();

        List<ObjectWord> words = new TableControllerWord(this).read(objectWord.getAssignmentNumber());

        if (words.size() > 0) {

            for (ObjectWord word : words) {
                int id = word.getId();
                String firstTranslation = word.getFirstTranslation();
                String secondTranslation = word.getSecondTranslation();

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