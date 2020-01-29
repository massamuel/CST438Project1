package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.room.Room;

import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class MainActivity extends AppCompatActivity {

    UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserDao = Room.databaseBuilder(this, UserDatabase.class, UserDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

    }
}
