package example.com.vocabularylearningapp.onClickListeners;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;

public class OnClickListenerNewWordButton implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        final Context context = view.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("InflateParams") final View formElementsView = inflater.inflate(R.layout.word_input_form, null, false);

        final EditText editTextFirstTranslation = formElementsView.findViewById(R.id.editTextWordFirstTranslation);
        final EditText editTextSecondTranslation = formElementsView.findViewById(R.id.editTextWordSecondTranslation);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("New Word")
                .setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                                String wordFirstTranslation = editTextFirstTranslation.getText().toString();
                                String wordSecondTranslation = editTextSecondTranslation.getText().toString();

                                ObjectWord objectWord = new ObjectWord();
                                objectWord.setFirstTranslation(wordFirstTranslation);
                                objectWord.setSecondTranslation(wordSecondTranslation);

                                boolean createSuccessful = new TableControllerWord(context).create(objectWord);

                                if (createSuccessful){
                                    Toast.makeText(context, "The word will be saved.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "The word has not been saved.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).show();
    }
}
