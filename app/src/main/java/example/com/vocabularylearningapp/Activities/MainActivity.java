package example.com.vocabularylearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.onClickListeners.OnClickListenerDbButton;
import example.com.vocabularylearningapp.onClickListeners.OnClickListenerNewWordButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = findViewById(R.id.startButton);
        buttonStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,
                        ActivityAfterClickStartButton.class);
                startActivity(myIntent);
            }
        });

        Button buttonAddWord = findViewById(R.id.addWordButton);
        buttonAddWord.setOnClickListener(new OnClickListenerNewWordButton());

        Button buttonDb = findViewById(R.id.dbButton);
        buttonDb.setOnClickListener(new OnClickListenerDbButton());


    }

}
