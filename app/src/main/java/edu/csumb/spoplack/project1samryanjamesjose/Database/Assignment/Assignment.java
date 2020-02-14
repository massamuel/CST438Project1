package edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;

@Entity(tableName = AppDatabase.ASSINMENT_TABLE)
public class Assignment {

    @PrimaryKey(autoGenerate = true)
    private int assignmentId;
    private int maxScore;
    private int earnedScore;
    private int courseId;
    private int studentId;
    private int categoryId;

    public Assignment(int maxScore, int earnedScore, int courseId, int studentId, int categoryId) {
        this.maxScore = maxScore;
        this.earnedScore = earnedScore;
        this.courseId = courseId;
        this.studentId = studentId;
        this.categoryId = categoryId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getEarnedScore() {
        return earnedScore;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
