package edu.csumb.spoplack.project1samryanjamesjose.Database;


import edu.csumb.spoplack.project1samryanjamesjose.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Enrollment.EnrollmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.GradeCategory.GradeCategoryDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.GradeCategory.GradeCategory;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Enrollment.EnrollmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Enrollment.Enrollment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.User;
import edu.csumb.spoplack.project1samryanjamesjose.User;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Course.class,GradeCategory.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DBNAME = "AppDb";
    public static final String USER_TABLE = "userTable";
    public static final String COURSE_TABLE = "courseTable";
    public static final String GRADE_CATEGORY_TABLE = "gradeCategoryTable";
    public static final String ASSIGNMENT_TABLE = "AssignmentTable";
    public static final String ENROLLMENT_TABLE = "enrollmentTable";
    public abstract UserDao getUserDAO();
    public abstract CourseDao getCourseDao();
    public abstract GradeCategoryDao getGradeCategoryDao();
    public abstract AssignmentDao getAssignmentDao();
    public  abstract EnrollmentDao getEnrollmentDao();
}