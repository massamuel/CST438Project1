package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.csumb.spoplack.project1samryanjamesjose.Adpaters.CoursesAdapter;
import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class CoursesActivity extends AppCompatActivity {

    private CourseDao mCourseDao;

    private RecyclerView recyclerView;
    private CoursesAdapter coursesAdapter;
    private FloatingActionButton fab;
    private ArrayList<Course> userCourses;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        mCourseDao =  Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();

        userId = 1; // Todo: get userid from login page

        updateList();

        if(userCourses.isEmpty()) {
            Toast.makeText(this, "No classes yet", Toast.LENGTH_LONG).show();
        }

        fab = findViewById(R.id.fabAddCourse);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CoursesActivity.this, AddCourseActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        updateList();
    }

    private void updateList() {
        //TODO: change method to only grab curr user's classes once persisting user is set up
        userCourses = (ArrayList<Course>) mCourseDao.getAllCourses();
        coursesAdapter = new CoursesAdapter(userCourses, userId);

        recyclerView = findViewById(R.id.rvClasses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(coursesAdapter);
    }
}
