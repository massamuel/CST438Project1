package edu.csumb.spoplack.project1samryanjamesjose.Database.Enrollment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Enrollment_table")

public class Enrollment {

    @PrimaryKey(autoGenerate = true)

    public long StudentID;
    public long CourseID;
    public String EnrollmentDate;

    public Enrollment(long studentid, long courseid, String enrollmentDate) {
        this.StudentID = studentid;
        this.CourseID = courseid;
        this.EnrollmentDate = enrollmentDate;
    }

    public long getStudentID() {return StudentID;}
    public long getCourseID() {return CourseID;}
    public String EnrollmentDate() {return EnrollmentDate;}


    public void setStudentID(long studentID) {this.StudentID = studentID;}
    public void setCourseID(long CourseID) {this.CourseID = CourseID;}
    public void setEnrollmentDate(String EnrollmentDate) {this.EnrollmentDate = EnrollmentDate;}

    /*
    StudentID
CourseID
Enrollment Date

     */
}
