package edu.csumb.spoplack.project1samryanjamesjose.Database.User;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version=1)
public abstract class UserDatabase extends RoomDatabase {

    public static final String DBNAME = "db-grades-app";
    public static final String USER_TABLE = "user-table";
    public abstract UserDao getUserDAO();

}
