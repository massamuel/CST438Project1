package edu.csumb.spoplack.project1samryanjamesjose;

public class Assignment {

    private String Details;
    private double MaxScore;
    private double EarnedScore;
    private String AssignedDate;
    private String DueDate;
    private long CategoryID;
    private long CourseID;
    private long AssignmentID;

    public Assignment(String details,double maxScore, double earnedScore, String assignedDate, String dueDate, long categoryID, long courseID, long assignmentID) {
        this.Details = details;
        this.MaxScore = maxScore;
        this.EarnedScore = earnedScore;
        this.AssignedDate = assignedDate;
        this.DueDate = dueDate;
        this.CategoryID = categoryID;
        this.CourseID = courseID;
        this.AssignmentID = assignmentID;
    }

    public String getDetails() {return Details;}
    public double getMaxScore() {return MaxScore;}
    public double getEarnedScore() {return EarnedScore;}
    public String getAssignedDate() {return AssignedDate;}
    public String getDueDate() {return DueDate;}
    public long getCategoryID() {return CategoryID;}
    public long getCourseID() {return CourseID;}
    public long getAssignmentID() {return AssignmentID;}

    public void setDetails(String details) {this.Details = details;}
    public void setMaxScore(double maxScore) {this.MaxScore = maxScore;}
    public void setEarnedScore(double earnedScore) {this.EarnedScore = earnedScore;}
    public void setAssignedDate(String assignedDate) {this.AssignedDate = assignedDate;}
    public void setDueDate(String dueDate) {this.DueDate = dueDate;}
    public void setCategoryID(long categoryID) {this.CategoryID = categoryID;}
    public void setCourseID(long courseID) {this.CourseID = courseID;}
    public void setAssignmentID(long assignmentID) {this.AssignmentID = assignmentID;}

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




