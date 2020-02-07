package edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;



public interface AssignmentDao {

    @Insert
    void insert(Assignment assignment);

    @Update
    void update(Assignment assignment);

    @Delete
    void delete(Assignment assignment);

    @Query("SELECT * FROM "+ AppDatabase.ASSIGNMENT_TABLE)
    List<Assignment> getAllAssignments();
}
