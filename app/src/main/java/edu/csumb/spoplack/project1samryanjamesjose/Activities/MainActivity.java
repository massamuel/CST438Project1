package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;


import edu.csumb.spoplack.project1samryanjamesjose.DisplayGradesActivity;
import edu.csumb.spoplack.project1samryanjamesjose.EligibleActivity;

import edu.csumb.spoplack.project1samryanjamesjose.R;
import edu.csumb.spoplack.project1samryanjamesjose.UpdateGradesActivity;

public class MainActivity extends AppCompatActivity {

    UserDao mUserDao;

    private Button insertButton,
            displayButton,
            updateButton,
            eligibleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();


        insertButton = (Button) findViewById(R.id.insertButton);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insertGrade =
                        new Intent(getApplicationContext(), CoursesActivity.class);
                startActivity(insertGrade);
            }
        });

        displayButton = (Button) findViewById(R.id.displayButton);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayGrades =
                        new Intent(getApplicationContext(), DisplayGradesActivity.class);
                startActivity(displayGrades);
            }
        });

        updateButton = (Button) findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateGrades =
                        new Intent(getApplicationContext(), UpdateGradesActivity.class);
                startActivity(updateGrades);
            }
        });

        eligibleButton = (Button) findViewById(R.id.eligibleButton);
        eligibleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eligibleGrades =
                        new Intent(getApplicationContext(), EligibleActivity.class);
                startActivity(eligibleGrades);
            }
        });
    }
}
