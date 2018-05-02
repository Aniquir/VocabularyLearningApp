package example.com.vocabularylearningapp.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ObjectWordDAO {

    //create
    @Insert(onConflict = REPLACE)
    void insert(ObjectWord... words);

    //read
    @Query("SELECT * FROM words")
    List<ObjectWord> getAll();

    @Query("SELECT * FROM words WHERE id LIKE :id")
    ObjectWord getOneById(int id);

    //update
    @Update
    void update(ObjectWord... words);

    //delete
    @Delete
    void delete(ObjectWord words);

    @Query("DELETE FROM words")
    void deleteAllWords();

}
