package example.com.vocabularylearningapp.helpers;

import android.widget.Button;

public class ButtonEnable {

    public void disableButtonIfNoWords(Button button, int numberOfWords){
        if (numberOfWords < 1){
            button.setEnabled(false);
            button.getBackground().setAlpha(64);
        }
    }
}
