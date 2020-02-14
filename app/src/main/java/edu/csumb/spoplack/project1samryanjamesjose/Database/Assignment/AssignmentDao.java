package edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;

@Dao
public interface AssignmentDao {

    @Insert
    void insert(Assignment assignment);

    @Update
    void update(Assignment assignment);

    @Delete
    void delete(Assignment assignment);

    @Query("SELECT * FROM "+ AppDatabase.ASSINMENT_TABLE)
    List<Assignment> getAllAssignments();

    @Query("SELECT * FROM "+ AppDatabase.ASSINMENT_TABLE + " WHERE courseId = :courseId " +
            "AND studentId = :studentId")
    List<Assignment> getCourseAssignments(String courseId, String studentId);

}
