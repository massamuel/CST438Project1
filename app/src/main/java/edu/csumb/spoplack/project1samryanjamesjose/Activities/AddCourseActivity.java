package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class AddCourseActivity extends AppCompatActivity {

    private CourseDao mCourseDao;

    private Button submitButton;
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvProfessor;

    private TextView homeworkWeight;
    private TextView TestWeight;
    private TextView QuizWeight;
    private TextView ProjectWeight;

    private HashMap<String,Double> gradedWeights;


    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        Intent intent = getIntent();
        userId = intent.getIntExtra("userId", 1);

        mCourseDao =  Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();

        tvName = findViewById(R.id.tvClassName);
        tvProfessor = findViewById(R.id.tvProfessor);
        tvDescription = findViewById(R.id.tvDescription);
        homeworkWeight = findViewById(R.id.tvHomeworkWeight);
        TestWeight = findViewById(R.id.tvTestWeight);
        QuizWeight = findViewById(R.id.tvQuizWeight);
        ProjectWeight = findViewById(R.id.tvProjectWeight);

        submitButton = findViewById(R.id.addCourseButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourse();
            }
        });
    }

    private void addCourse() {
        gradedWeights = new HashMap<String,Double>();
        Double.parseDouble(homeworkWeight.getText().toString());
        gradedWeights.put("Homework",Double.parseDouble(homeworkWeight.getText().toString()));
        gradedWeights.put("Test",Double.parseDouble(TestWeight.getText().toString()));
        gradedWeights.put("Projects",Double.parseDouble(ProjectWeight.getText().toString()));
        gradedWeights.put("Quiz",Double.parseDouble(QuizWeight.getText().toString()));


        String name = tvName.getText().toString();
        String professor = tvProfessor.getText().toString();
        String description = tvDescription.getText().toString();
        if(name.length() != 0 && professor.length() != 0 && description.length() != 0) {
            Course course = new Course(professor, name, description, "none", "none", userId, gradedWeights);
            mCourseDao.insert(course);
            finish();
        } else {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_LONG).show();
        }
    }
}
