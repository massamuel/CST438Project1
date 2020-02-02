package edu.csumb.spoplack.project1samryanjamesjose.Database.Course;


import java.util.List;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;

public interface CourseDao {

    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM "+ AppDatabase.USER_TABLE)
    List<User> getAllCourse();

}
