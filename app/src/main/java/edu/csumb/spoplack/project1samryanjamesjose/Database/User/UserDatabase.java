package edu.csumb.spoplack.project1samryanjamesjose.Database.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version=1)
public abstract class UserDatabase extends RoomDatabase {

    public static final String DBNAME = "dbGradesApp";
    public static final String USER_TABLE = "userTable";
    public abstract UserDao getUserDAO();

}
