package edu.csumb.spoplack.project1samryanjamesjose.Database;


import edu.csumb.spoplack.project1samryanjamesjose.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.User;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Course.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DBNAME = "AppDb";
    public static final String USER_TABLE = "userTable";
    public abstract UserDao getUserDAO();
    public abstract CourseDao getCourseDao();

}