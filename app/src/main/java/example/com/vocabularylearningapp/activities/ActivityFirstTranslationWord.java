package example.com.vocabularylearningapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import example.com.vocabularylearningapp.R;

public class ActivityFirstTranslationWord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_choosing_the_learning_option);
//        readWord();

        Button nextButton = findViewById(R.id.buttonToGoNextFirstTranslation);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_after_click_go_to_next_first_translation);
            }
        });

    }
    //random function to choose some id(word) to show in first and second translation page
    //id in db
//    int[] numbers = {2,4,8,16,32,64,128,256,512,1024,2048};
    //random function
//    int random = new Random().nextInt(numbers.length);
//    result to check
//        System.out.println(numbers[random]);
}
