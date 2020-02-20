package edu.csumb.spoplack.project1samryanjamesjose;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    private UserDao userDao;
    private CourseDao courseDao;
    private AssignmentDao assignmentDao;
    private AppDatabase db;
    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(),
                AppDatabase.class)
                .allowMainThreadQueries()
                .build();


        userDao = db.getUserDAO();
        courseDao = db.getCourseDAO();
        assignmentDao = db.getAssignmentDAO();
    }


    @Test public void userInsert() {
        User testValue = new User("rbeck", "password", "Ryan", "Beck");
        userDao.insert(testValue);
        List<User> DBvalue = userDao.getAllUsers();
        //There should only be one entry...
        assertEquals(1,DBvalue.size());

        assertEquals(testValue.getUserName(),DBvalue.get(0).getUserName());
        //assertEquals(testValue,DBvalue.get(0));
    }

    @Test public void courseInsert() {
        User user = new User("username", "password", "first", "last");
        Course course = new Course("teacher", "className", "desc",
                "date1", "date2", user.getUserId());
        courseDao.insert(course);
        List<Course> courses = courseDao.getAllCourses();
        assertEquals(1, courses.size());
        assertEquals(course.getTitle(), courses.get(0).getTitle());
    }

    @Test public void getUserCourses() {
        User user = new User("username", "password", "first", "last");
        int uid = user.getUserId();
        Course course1 = new Course("teacher", "myClass", "desc",
                "date1", "date2", uid);
        Course course2 = new Course("teacher", "notMyClass", "desc",
                "date1", "date2", -1);
        courseDao.insert(course1);
        courseDao.insert(course2);
        List<Course> courses = courseDao.getUsersCourses(Integer.toString(uid));
        assertEquals(1, courses.size());
        assertEquals(course1.getTitle(), courses.get(0).getTitle());
    }

    @Test public void assignmentInsert() {
        User user = new User("username", "password", "first", "last");
        Course course = new Course("teacher", "className", "desc",
                "date1", "date2", user.getUserId());
        Assignment assignment = new Assignment(20, 18, course.getCourseId(),
                                user.getUserId(), -1, "name");
        assignmentDao.insert(assignment);
        List<Assignment> assignments = assignmentDao.getAllAssignments();
        assertEquals(1, assignments.size());
        assertEquals(assignment.getMaxScore(), assignments.get(0).getMaxScore());
    }

    @Test public void getCourseAssignments() {
        User user1 = new User("username", "password", "first", "last");
        user1.setUserId(1);
        User user2 = new User("userName2", "password2", "first2", "");
        user2.setUserId(2);

        Course course1 = new Course("teacher", "myClass", "desc",
                "date1", "date2", user1.getUserId());
        course1.setCourseId(1);
        Course course2 = new Course("teacher3", "myOtherClass", "desc",
                "date1", "date2", user1.getUserId());
        course2.setCourseId(2);

        Assignment assignment1 = new Assignment(20, 20, course1.getCourseId(),
                user1.getUserId(), -1, "name") ;
        Assignment assignment2 = new Assignment(20, 15, course1.getCourseId(),
                user1.getUserId(), -1, "name");
        Assignment assignment3 = new Assignment(20, 17, course2.getCourseId(),
                user1.getUserId(), -1, "name");
        Assignment assignment4 = new Assignment(20, 18, course1.getCourseId(),
                user2.getUserId(), -1, "name");
        assignmentDao.insert(assignment1);
        assignmentDao.insert(assignment2);
        assignmentDao.insert(assignment3);
        assignmentDao.insert(assignment4);

        List<Assignment> courseAssignments = assignmentDao.getCourseAssignments(
                Integer.toString(course1.getCourseId()),
                Integer.toString(user1.getUserId()));

        assertEquals(2, courseAssignments.size());
        assertEquals(course1.getCourseId(), courseAssignments.get(0).getCourseId());
        assertEquals(course1.getCourseId(), courseAssignments.get(1).getCourseId());
        assertEquals(user1.getUserId(), courseAssignments.get(0).getStudentId());
        assertEquals(user1.getUserId(), courseAssignments.get(1).getStudentId());
    }

    @Test public void calculateGrade() {
        User user1 = new User("username", "password", "first", "last");
        Course course1 = new Course("teacher", "myClass", "desc",
                "date1", "date2", user1.getUserId());

        HashMap<String, Double> weights = Assignment.gWeights;

        Assignment assignment1 = new Assignment(20, 20, course1.getCourseId(),
                user1.getUserId(), weights.get("Homework"), "name");
        Assignment assignment2 = new Assignment(20, 15, course1.getCourseId(),
                user1.getUserId(), weights.get("Test"), "name");
        Assignment assignment3 = new Assignment(20, 18, course1.getCourseId(),
                user1.getUserId(), weights.get("Quiz"), "name");
        Assignment assignment4 = new Assignment(20, 20, course1.getCourseId(),
                user1.getUserId(), weights.get("Projects"), "name");

        assignmentDao.insert(assignment1);
        assignmentDao.insert(assignment2);
        assignmentDao.insert(assignment3);
        assignmentDao.insert(assignment4);

        List<Assignment> courseAssignments = assignmentDao.getCourseAssignments(
                Integer.toString(course1.getCourseId()),
                Integer.toString(user1.getUserId()));

        Double calculatedGrade = calculate(courseAssignments);
        //Worked out the math by hand, checking to see if function returns value close enough to what grade should be
        assertTrue(Math.abs(0.9025 - calculatedGrade) < 0.0001);

    }

    private Double calculate(List<Assignment> assignments){
        Double total = 0.0;
        Double earned = 0.0;
        for(Assignment assignment : assignments) {
            total += assignment.getCategoryWeight() * assignment.getMaxScore();
            earned += assignment.getCategoryWeight() * assignment.getEarnedScore();
        }
        return earned / total;
    }
}
