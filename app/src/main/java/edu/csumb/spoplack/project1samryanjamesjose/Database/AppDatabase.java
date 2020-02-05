package edu.csumb.spoplack.project1samryanjamesjose.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;

@Database(entities = {User.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DBNAME = "dbGradesApp";
    public static final String USER_TABLE = "userTable";
    public abstract UserDao getUserDAO();

}
