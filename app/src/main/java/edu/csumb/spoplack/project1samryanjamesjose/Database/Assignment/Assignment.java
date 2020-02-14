package edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import java.util.HashMap;

@Entity(tableName = AppDatabase.ASSIGNMENT_TABLE)

public class Assignment {

    public static HashMap<String,Double> score_weights = new HashMap<String,Double>();

    score_weights.put()

    private String Details;
    private double MaxScore;
    private double EarnedScore;
    private String AssignedDate;
    private String DueDate;
    private long CategoryID;
    private long CourseID;
    @PrimaryKey(autoGenerate = true)
    private long AssignmentID;

    private String dateEarned;
    private long gradeID;
    private long studentID;
    private double score;
    //DateEarned
    //gradeID
    //StudentID
    //score

    public Assignment(String details,double maxScore, double earnedScore, String assignedDate, String dueDate, long categoryID, long courseID, long assignmentID,
                      String dateEarned,long gradeID, long studentID, double score) {
        this.Details = details;
        this.MaxScore = maxScore;
        this.EarnedScore = earnedScore;
        this.AssignedDate = assignedDate;
        this.DueDate = dueDate;
        this.CategoryID = categoryID;
        this.CourseID = courseID;
        this.AssignmentID = assignmentID;
        this.dateEarned = dateEarned;
        this.gradeID = gradeID;
        this.studentID = studentID;
        this.score = score;
    }

    public String getDetails() {return Details;}
    public double getMaxScore() {return MaxScore;}
    public double getEarnedScore() {return EarnedScore;}
    public String getAssignedDate() {return AssignedDate;}
    public String getDueDate() {return DueDate;}
    public long getCategoryID() {return CategoryID;}
    public long getCourseID() {return CourseID;}
    public long getAssignmentID() {return AssignmentID;}

    public String getDateEarned() {return dateEarned;}
    public long getGradeID() {return gradeID;}
    public long getStudentID(){return studentID;}
    public double getScore() {return score;}

    public void setDetails(String details) {this.Details = details;}
    public void setMaxScore(double maxScore) {this.MaxScore = maxScore;}
    public void setEarnedScore(double earnedScore) {this.EarnedScore = earnedScore;}
    public void setAssignedDate(String assignedDate) {this.AssignedDate = assignedDate;}
    public void setDueDate(String dueDate) {this.DueDate = dueDate;}
    public void setCategoryID(long categoryID) {this.CategoryID = categoryID;}
    public void setCourseID(long courseID) {this.CourseID = courseID;}
    public void setAssignmentID(long assignmentID) {this.AssignmentID = assignmentID;}

    public void setDateEarned(String dateEarned) {this.dateEarned = dateEarned;}
    public void setGradeID(long gradeID) {this.gradeID =  gradeID;}
    public void setStudentID(long studentID){this.studentID =  studentID;}
    public void setScore(double score) {this.score = score;}


    /*
    Details
Max Score
Earned Score
Assigned date
Due date
CategoryID
CourseID
AssignmentID
     */
}
