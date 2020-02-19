package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class AddCourseActivity extends AppCompatActivity {

    private CourseDao mCourseDao;

    private Button submitButton;
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvProfessor;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        mCourseDao =  Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();

        tvName = findViewById(R.id.tvClassName);
        tvProfessor = findViewById(R.id.tvProfessor);
        tvDescription = findViewById(R.id.tvDescription);

        submitButton = findViewById(R.id.addCourseButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourse();
            }
        });
    }

    private void addCourse() {
        String name = tvName.getText().toString();
        String professor = tvProfessor.getText().toString();
        String description = tvDescription.getText().toString();
        if(name.length() != 0 && professor.length() != 0 && description.length() != 0) {
            //TODO: get users id when inserting course
            Course course = new Course(professor, name, description, "none", "none", 1);
            mCourseDao.insert(course);
            finish();
        } else {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_LONG).show();
        }
    }
}
