package edu.csumb.spoplack.project1samryanjamesjose.Database.User;


<<<<<<< HEAD
import android.media.session.MediaSession;

import androidx.room.ColumnInfo;
=======
>>>>>>> ed74dec8d5a08c4372b7b9f5d62d867c43ac47de
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

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE userName = :userName AND password = :password")
    List<User> getAllUsers(String userName, String password);









}
