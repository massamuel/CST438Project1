package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.room.Room;

import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.HomeFragment;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class MainActivity extends AppCompatActivity {

    UserDao mUserDao;
    public static FragmentManager fragmentManager;
    public static UserDatabase myDb;
    public static UserDao myDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);

        fragmentManager = getSupportFragmentManager();

        mUserDao = Room.databaseBuilder(this, UserDatabase.class, UserDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        myDb = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, UserDatabase.USER_TABLE)
                .allowMainThreadQueries()
                .build();

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }




    }
}
