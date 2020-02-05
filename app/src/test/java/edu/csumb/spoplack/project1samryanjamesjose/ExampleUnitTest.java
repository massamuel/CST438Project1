package edu.csumb.spoplack.project1samryanjamesjose;

import org.junit.Test;

import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;

//import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.ext.junit.runners.AndroidJUnit4;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
public class ExampleUnitTest {

    @Test public void useAppContext() {
        // Context of the app under test.
        //Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

       // assertEquals("edu.csumb.spoplack.project1samryanjamesjose", appContext.getPackageName());
    }

    @Test void insertionWorks() {
        UserDao mUserDao;

//        mUserDao = Room.databaseBuilder(this, UserDatabase.class, UserDatabase.DBNAME)
//                .allowMainThreadQueries()
//                .build()
//                .getUserDAO();

//        User testUser = new User("rbeck", "password", "Ryan", "Beck");
//        mUserDao.insert(testUser);
//
//        List<User> allUsers = mUserDao.getAllUsers();
//        User user = allUsers.get(0);
//        assertEquals(user.getUserName(), "rbeck");
//        assertEquals(user.getPassword(), "password");
//        assertEquals(user.getFirstName(), "Ryan");
//        assertEquals(user.getLastName(), "Beck");
    }
}