package edu.csumb.spoplack.project1samryanjamesjose.Database;



import edu.csumb.spoplack.project1samryanjamesjose.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Enrollment.EnrollmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.GradeCategory.GradeCategoryDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.GradeCategory.GradeCategory;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;

import edu.csumb.spoplack.project1samryanjamesjose.Database.Enrollment.Enrollment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;



import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Course.class,GradeCategory.class, Assignment.class, Enrollment.class}, version=1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DBNAME = "dbGradesApp";
    public static final String USER_TABLE = "userTable";
    public static final String COURSE_TABLE = "courseTable";
    public abstract UserDao getUserDAO();
    public abstract CourseDao getCourseDAO();
}




