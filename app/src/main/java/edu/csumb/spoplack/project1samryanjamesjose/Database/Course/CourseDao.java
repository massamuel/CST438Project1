package edu.csumb.spoplack.project1samryanjamesjose.Database.Course;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;

@Dao
public interface CourseDao {

    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM "+ AppDatabase.COURSE_TABLE)
    List<Course> getAllCourses();
    
    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE + " WHERE studentId = :id")
    List<Course> getUsersCourses(String id);

}
