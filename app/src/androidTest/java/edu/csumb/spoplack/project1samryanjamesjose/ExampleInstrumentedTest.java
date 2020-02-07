package edu.csumb.spoplack.project1samryanjamesjose;

import android.content.Context;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getContext();

        assertEquals("edu.csumb.spoplack.project1samryanjamesjose", appContext.getPackageName());
    }


    private UserDao userDao;
    private AppDatabase db;
    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(),
                AppDatabase.class)
                .allowMainThreadQueries()
                .build();


        userDao = db.getUserDAO();
    }


    @Test public void insertionWorks() {
        User testValue = new User("rbeck", "password", "Ryan", "Beck");
        userDao.insert(testValue);
        List<User> DBvalue = userDao.getAllUsers();
        //There should only be one entry...
        assertEquals(1,DBvalue.size());

        assertEquals(testValue.getUserName(),DBvalue.get(0).getUserName());
        //assertEquals(testValue,DBvalue.get(0));
    }
}
