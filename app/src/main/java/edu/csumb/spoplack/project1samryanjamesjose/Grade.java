package edu.csumb.spoplack.project1samryanjamesjose;

public class Grade {
    private double score;
    private long AssigmentID;
    private long studentID;
    private long CourseID;
    private String DateEarned;
    private long gradeID;

    public Grade(double score, long assigmentID, long studentID, long courseID, String dateEarned, long gradeID) {
        this.score = score;
        this.AssigmentID = assigmentID;
        this.studentID = studentID;
        this.CourseID = courseID;
        this.DateEarned = dateEarned;
        this.gradeID = gradeID;
    }

    public double getScore(){return score;}
    public long getAssigmentID(){return AssigmentID;}
    public long getStudentID(){return studentID;}
    public long getCourseID(){return CourseID;}
    public String getDateEarned(){return DateEarned;}
    public long getGradeID(){return gradeID;}

    public void setScore(double score){this.score = score;}
    public void setAssigmentID(long assigmentID) {this.AssigmentID = assigmentID;}
    public void setStudentID(long studentID) {this.studentID = studentID;}
    public void setCourseID(long courseID){this.CourseID = courseID;}
    public void  setDateEarned(String dateEarned){this.DateEarned = dateEarned;}
    public void setGradeID(long gradeID){this.gradeID = gradeID;}

    /*
    score
AssigmentID
studentID
CourseID
date earned
gradeID

     */



}
