package example.com.vocabularylearningapp.onClickListeners;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import example.com.vocabularylearningapp.R;
import example.com.vocabularylearningapp.activities.ActivityAfterClickDbButton;
import example.com.vocabularylearningapp.activities.ActivityDatabaseView;
import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;

public class OnLongClickListenerWordRecord implements View.OnLongClickListener {

    Context context;
    String id;

    @Override
    public boolean onLongClick(View v) {
        context = v.getContext();
        id = v.getTag().toString();

        final CharSequence[] items = {"EDIT", "DELETE"};
        new AlertDialog.Builder(context, R.style.MyDialogTheme)
                .setTitle("What you want to do?")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {

                        dialog.dismiss();
                        //update
                        if (item == 0) {
                            editRecord(Integer.parseInt(id));
                        //delete
                        } else if (item == 1) {

                            boolean deleteSuccessful = new TableControllerWord(context).delete(Integer.parseInt(id));

                            if (deleteSuccessful) {
                                Toast.makeText(context, "the word has been removed.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "the word can not be deleted", Toast.LENGTH_SHORT).show();
                            }
                            ((ActivityDatabaseView) context).countRecords(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);
                            ((ActivityDatabaseView) context).readRecords(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);
                        }
                    }
                }).show();
        return false;
    }

    private void editRecord(final int wordId) {

        final TableControllerWord tableControllerWord = new TableControllerWord(context);
        ObjectWord objectWord = tableControllerWord.readSingleRecord(wordId);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View formElementsView = inflater.inflate(R.layout.word_input_form, null, false);

        final EditText editTextWordFirstTranslation = formElementsView.findViewById(R.id.editTextWordFirstTranslation);
        final EditText editTextWordSecondTranslation = formElementsView.findViewById(R.id.editTextWordSecondTranslation);

        editTextWordFirstTranslation.setText(objectWord.getFirstTranslation());
        editTextWordSecondTranslation.setText(objectWord.getSecondTranslation());

        new AlertDialog.Builder(context, R.style.MyDialogTheme)
                .setView(formElementsView)
                .setTitle("edit word")
                .setPositiveButton("save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        ObjectWord objectWord = new ObjectWord();
                        objectWord.setId(wordId);
                        objectWord.setFirstTranslation(editTextWordFirstTranslation.getText().toString());
                        objectWord.setSecondTranslation(editTextWordSecondTranslation.getText().toString());
                        objectWord.setAssignmentNumber(objectWord.getAssignmentNumber());

                        boolean updateSuccessful = tableControllerWord.update(objectWord);

                        if (updateSuccessful) {
                            Toast.makeText(context, "word has been updated", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "the word can not be updated", Toast.LENGTH_SHORT).show();
                        }
                        ((ActivityDatabaseView) context).countRecords(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);
                        ((ActivityDatabaseView) context).readRecords(ActivityAfterClickDbButton.numNeededToDisplayCorrectDb);
                    }
                }).show();
    }
}
