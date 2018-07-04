package example.com.vocabularylearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;
import example.com.vocabularylearningapp.onClickListeners.OnClickListenerNewWordButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        add basic database if doesn't exist
        if (new TableControllerWord(this).isDbEmpty()) {
            readBasicDatabaseFromRes();
        }

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
        buttonDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntenet2 = new Intent(MainActivity.this,
                        ActivityAfterClickDbButton.class);
                startActivity(myIntenet2);
            }
        });
    }

    private void readBasicDatabaseFromRes() {
        InputStream inputStream = getResources().openRawResource(R.raw.database);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, Charset.forName("windows-1250"))
        );

        String line = "";

        try {

            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(";");

                ObjectWord objectWord = new ObjectWord();

                objectWord.setFirstTranslation(tokens[0]);
                objectWord.setSecondTranslation(tokens[1]);

                new TableControllerWord(this).create(objectWord);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

