package example.com.vocabularylearningapp.databases;

import java.util.List;

import example.com.vocabularylearningapp.entity.ObjectWord;
import example.com.vocabularylearningapp.entity.ObjectWordDAO;

public class ObjectWordDataSource implements IObjectWordDataSource {

    private ObjectWordDAO objectWordDAO;
    private static ObjectWordDataSource mInstanceNewWord;
    private static ObjectWordDataSource mInstanceRepeatWord;
    private static ObjectWordDataSource mInstanceKnownWord;

    public ObjectWordDataSource(ObjectWordDAO objectWordDAO) {
        this.objectWordDAO = objectWordDAO;
    }

    public static ObjectWordDataSource getInstanceNewWord(ObjectWordDAO objectWordDAO){

        if(mInstanceNewWord == null){
            mInstanceNewWord = new ObjectWordDataSource(objectWordDAO);
        }
        return mInstanceNewWord;
    }
    public static ObjectWordDataSource getInstanceRepeatWord(ObjectWordDAO objectWordDAO){

        if(mInstanceRepeatWord == null){
            mInstanceRepeatWord = new ObjectWordDataSource(objectWordDAO);
        }
        return mInstanceRepeatWord;
    }
    public static ObjectWordDataSource getInstanceKnownWord(ObjectWordDAO objectWordDAO){

        if(mInstanceKnownWord == null){
            mInstanceKnownWord = new ObjectWordDataSource(objectWordDAO);
        }
        return mInstanceKnownWord;
    }


    @Override
    public void insert(ObjectWord... words) {
        objectWordDAO.insert(words);
    }

    @Override
    public List<ObjectWord> getAll() {
        return objectWordDAO.getAll();
    }

    @Override
    public ObjectWord getOneById(int id) {
        return objectWordDAO.getOneById(id);
    }

    @Override
    public void update(ObjectWord... words) {
        objectWordDAO.update(words);
    }

    @Override
    public void delete(ObjectWord words) {
        objectWordDAO.delete(words);
    }

    @Override
    public void deleteAllWords() {
        objectWordDAO.deleteAllWords();
    }
}
