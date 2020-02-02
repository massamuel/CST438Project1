package edu.csumb.spoplack.project1samryanjamesjose;

import java.util.Date;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private String Instructor;
    private String Title;
    private String Description;
    private String StartDate;
    private String EndDate;
    private long courseID;


    public Course(String Instructor,String Title,String Description,String StartDate, String EndDate, long courseID ) {
        this.Instructor = Instructor;
        this.Title = Title;
        this.Description = Description;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.courseID = courseID;
    }

    public String getInstructor() { return Instructor;}
    public String getTitle() { return Title;}
    public String getDescription() { return Description;}
    public String getStartDate() { return StartDate;}
    public String getEndDate() { return EndDate;}
    public long getCourseID() { return courseID;}


    public void setInstructor(String instructor) {this.Instructor = instructor;}
    public void setTitle(String title) {this.Title = title;}
    public void setDescription(String description) {this.Description = description;}
    public void setStartDate(String startDate) {this.StartDate = startDate;}
    public void setEndDate(String endDate) {this.EndDate = endDate;}

/*
Instructor
Title
Description
Start Date
End Date
courseID

 */


}
