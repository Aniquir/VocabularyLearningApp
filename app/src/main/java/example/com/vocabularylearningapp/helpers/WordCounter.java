package example.com.vocabularylearningapp.helpers;

import java.util.List;

import example.com.vocabularylearningapp.entity.ObjectWord;

public class WordCounter {

    public int counterOfSelectedWords(List<ObjectWord> words){
        int counter = 0;
        for (int i = 0; i < words.size(); i++) {
            counter++;
        }
        return counter;
    }
}
