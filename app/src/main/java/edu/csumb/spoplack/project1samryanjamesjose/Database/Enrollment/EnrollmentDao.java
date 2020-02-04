package edu.csumb.spoplack.project1samryanjamesjose.Database.Enrollment;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.GradeCategory.GradeCategory;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;

public interface EnrollmentDao {

    @Insert
    void insert(GradeCategory gc);

    @Update
    void update(GradeCategory gc);

    @Delete
    void delete(GradeCategory gc);

    @Query("SELECT * FROM "+ AppDatabase.ENROLLMENT_TABLE)
    List<User> getAllAssignments();
}
