package edu.csumb.spoplack.project1samryanjamesjose.Database.Course;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int courseId;
    private String instructor;
    private String title;
    private String description;
    private String startDate;
    private String endDate;

    public Course(String instructor, String title, String description, String startDate, String endDate) {
        this.instructor = instructor;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
}
