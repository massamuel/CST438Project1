package edu.csumb.spoplack.project1samryanjamesjose.Database.User;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM "+ AppDatabase.USER_TABLE)
    List<User> getAllUsers();


}
