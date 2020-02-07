package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.os.Bundle;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.room.Room;

import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.List;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class CoursesActivity extends AppCompatActivity {

    private CourseDao mCourseDao;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        mCourseDao =  Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();

        List<Course> userCourses = mCourseDao.getAllCourses();

        recyclerView = findViewById(R.id.rvClasses);

        if(userCourses.isEmpty()) {
            Toast.makeText(this, "No classes yet!", Toast.LENGTH_LONG).show();
        } else {
            //TODO: populate recycler view with userCourses
        }
    }
}
