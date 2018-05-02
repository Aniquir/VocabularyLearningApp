package example.com.vocabularylearningapp.databases;

import java.util.List;

import example.com.vocabularylearningapp.entity.ObjectWord;

public class ObjectWordRepository implements IObjectWordDataSource {

    private IObjectWordDataSource mLocalDataSource;

    private static ObjectWordRepository mInstanceNewWord;
    private static ObjectWordRepository mInstanceRepeatWord;
    private static ObjectWordRepository mInstanceKnownWord;

    public ObjectWordRepository(IObjectWordDataSource mLocalDataSOurce) {
        this.mLocalDataSource = mLocalDataSOurce;
    }

    private static ObjectWordRepository getInstanceNewWord(IObjectWordDataSource mLocalDataSource){

        if (mInstanceNewWord == null){
            mInstanceNewWord = new ObjectWordRepository(mLocalDataSource);
        }
        return mInstanceNewWord;
    }
    private static ObjectWordRepository getInstanceRepeatWord(IObjectWordDataSource mLocalDataSource){

        if (mInstanceRepeatWord == null){
            mInstanceRepeatWord = new ObjectWordRepository(mLocalDataSource);
        }
        return mInstanceRepeatWord;
    }
    private static ObjectWordRepository getInstanceKnownWord(IObjectWordDataSource mLocalDataSource){

        if (mInstanceKnownWord == null){
            mInstanceKnownWord = new ObjectWordRepository(mLocalDataSource);
        }
        return mInstanceKnownWord;
    }

    @Override
    public void insert(ObjectWord... words) {
        mLocalDataSource.insert(words);
    }

    @Override
    public List<ObjectWord> getAll() {
        return mLocalDataSource.getAll();
    }

    @Override
    public ObjectWord getOneById(int id) {
        return mLocalDataSource.getOneById(id);
    }

    @Override
    public void update(ObjectWord... words) {
        mLocalDataSource.update(words);
    }

    @Override
    public void delete(ObjectWord words) {
        mLocalDataSource.delete(words);
    }

    @Override
    public void deleteAllWords() {
        mLocalDataSource.deleteAllWords();
    }
}
