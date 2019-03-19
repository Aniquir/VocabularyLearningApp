package example.com.vocabularylearningapp.helpers;

import java.util.List;

import example.com.vocabularylearningapp.database.TableControllerWord;
import example.com.vocabularylearningapp.entity.ObjectWord;

public class AssignmentNumberCorrector {

    public void updateToCorrectAssignmentNumbersOfWords(TableControllerWord tableControllerWord, List<ObjectWord> wordsToUpdate){

        for (int i = 0; i < wordsToUpdate.size(); i++) {
            if (wordsToUpdate.get(i).getAssignmentNumber() == 3){
                tableControllerWord.updateByChangeAssignmentNumber(wordsToUpdate.get(i),1);
            }
            if (wordsToUpdate.get(i).getAssignmentNumber() == 4){
                tableControllerWord.updateByChangeAssignmentNumber(wordsToUpdate.get(i),2);
            }
        }
    }
}
