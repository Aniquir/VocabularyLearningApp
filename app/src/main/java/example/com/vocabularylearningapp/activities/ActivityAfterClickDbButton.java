package example.com.vocabularylearningapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.entity.ObjectWord;

public class ActivityAfterClickDbButton extends AppCompatActivity {

    ObjectWord objectWord = new ObjectWord();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_db_button);

        Button newWordButton = findViewById(R.id.buttonDbNewWords);
        newWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Context context = v.getContext();
                objectWord.setAssignmentNumber(0);
                setContentView(R.layout.activity_database_view);
            }
        });

        Button repeatWordButton = findViewById(R.id.buttonDbRepeatWords);
        repeatWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Context context = v.getContext();
                objectWord.setAssignmentNumber(1);
                setContentView(R.layout.activity_database_view);
            }
        });

        Button knownWordButton = findViewById(R.id.buttonDbKnownWords);
        knownWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Context context = v.getContext();
                objectWord.setAssignmentNumber(2);
                setContentView(R.layout.activity_database_view);
            }
        });
    }


}
