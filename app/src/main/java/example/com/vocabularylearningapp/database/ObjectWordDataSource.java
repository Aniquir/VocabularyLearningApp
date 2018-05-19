package example.com.vocabularylearningapp.database;

import java.util.List;

import example.com.vocabularylearningapp.entity.ObjectWord;
import example.com.vocabularylearningapp.entity.ObjectWordDAO;

public class ObjectWordDataSource implements ObjectWordDAO {

    private ObjectWordDAO objectWordDAO;
    private static ObjectWordDataSource mInstanceDatabaseOfWords;


    public ObjectWordDataSource(ObjectWordDAO objectWordDAO) {
        this.objectWordDAO = objectWordDAO;
    }

    public static ObjectWordDataSource getInstanceDatabaseOfWords(ObjectWordDAO objectWordDAO){

        if(mInstanceDatabaseOfWords == null){
            mInstanceDatabaseOfWords = new ObjectWordDataSource(objectWordDAO);
        }
        return mInstanceDatabaseOfWords;
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
