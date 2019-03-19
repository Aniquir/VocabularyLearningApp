package example.com.vocabularylearningapp.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "words")
public class ObjectWord {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "first_translation")
    private
    String firstTranslation;

    @ColumnInfo(name = "second_translation")
    private
    String secondTranslation;

    @ColumnInfo(name = "assignment_number")
    private
    int assignmentNumber;

    public ObjectWord() {
    }

    @Ignore
    public ObjectWord(String firstTranslation, String secondTranslation, int assignmentNumber) {
        this.firstTranslation = firstTranslation;
        this.secondTranslation = secondTranslation;
        this.assignmentNumber = assignmentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstTranslation() {
        return firstTranslation;
    }

    public void setFirstTranslation(String firstTranslation) {
        this.firstTranslation = firstTranslation;
    }

    public String getSecondTranslation() {
        return secondTranslation;
    }

    public void setSecondTranslation(String secondTranslation) {
        this.secondTranslation = secondTranslation;
    }

    public int getAssignmentNumber() {
        return assignmentNumber;
    }
    public int getAssignmentNumberWhenCreateNewObjectWord(){
        return 0;
    }

    public void setAssignmentNumber(int assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }
}
