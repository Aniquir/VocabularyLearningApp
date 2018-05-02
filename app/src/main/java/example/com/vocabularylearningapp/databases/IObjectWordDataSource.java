package example.com.vocabularylearningapp.databases;

import java.util.List;

import example.com.vocabularylearningapp.entity.ObjectWord;

public interface IObjectWordDataSource {

    //create
    void insert(ObjectWord... words);

    //read
    List<ObjectWord> getAll();
    ObjectWord getOneById(int id);

    //update
    void update(ObjectWord... words);

    //delete
    void delete(ObjectWord words);
    void deleteAllWords();
}
