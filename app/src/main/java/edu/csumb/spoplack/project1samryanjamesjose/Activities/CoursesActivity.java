package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        mCourseDao =  Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();


        ArrayList<Course> userCourses = (ArrayList<Course>) mCourseDao.getAllCourses();
        coursesAdapter = new CoursesAdapter(userCourses);


        recyclerView = findViewById(R.id.rvClasses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(coursesAdapter);

        if(userCourses.isEmpty()) {
            Course cst438 = new Course("Dr. ClinkenBeard", "CST438", "Good class", "January 26", "May 9", 1);
            mCourseDao.insert(cst438);
            coursesAdapter.notifyItemInserted(0);
        }
    }
}
