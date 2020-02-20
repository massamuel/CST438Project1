package edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.HashMap;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;

@Entity(tableName = AppDatabase.ASSIGNMENT_TABLE)
public class Assignment {

    public static HashMap<String,Double> gWeights = new HashMap<>();
    static {
        gWeights.put("Homework",0.3);
        gWeights.put("Test",0.35);
        gWeights.put("Projects",0.25);
        gWeights.put("Quiz",0.1);
    }

    @PrimaryKey(autoGenerate = true)
    private int assignmentId;
    private double maxScore;
    private double earnedScore;
    private int courseId;
    private int studentId;
    private double categoryWeight;
    private String assignmentName;

    public Assignment(double maxScore, double earnedScore, int courseId, int studentId, double categoryWeight, String assignmentName) {
        this.maxScore = maxScore;
        this.earnedScore = earnedScore;
        this.courseId = courseId;
        this.studentId = studentId;
        this.categoryWeight = categoryWeight;
        this.assignmentName = assignmentName;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public double getEarnedScore() {
        return earnedScore;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getCategoryWeight() {
        return categoryWeight;
    }

    public String getAssignmentName() {
        return assignmentName;
    }
}
