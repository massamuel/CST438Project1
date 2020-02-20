package edu.csumb.spoplack.project1samryanjamesjose.Database.Course;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courseTable")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int courseId;
    private String instructor;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private int studentId;
    private Double courseGrade;

    public Course(String instructor, String title, String description, String startDate, String endDate, Integer studentId) {
        this.instructor = instructor;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentId = studentId;
        this.courseGrade = 0.0;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseGrade(Double courseGrade) {
        this.courseGrade = courseGrade;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getStudentId() { return studentId; }

    public Double getCourseGrade() {
        return courseGrade;
    }
}
