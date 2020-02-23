package edu.csumb.spoplack.project1samryanjamesjose.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;

@Database(entities = {User.class, Course.class, Assignment.class}, version=1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DBNAME = "dbGradesApp";
    public static final String USER_TABLE = "userTable";
    public static final String COURSE_TABLE = "courseTable";
    public static final String ASSIGNMENT_TABLE = "assignmentTable";
    public abstract UserDao getUserDAO();
    public abstract CourseDao getCourseDAO();
    public abstract AssignmentDao getAssignmentDAO();

}
