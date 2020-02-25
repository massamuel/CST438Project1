package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.HashMap;
import java.util.List;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class InsertGradeActivity extends AppCompatActivity {


    private AssignmentDao assignmentDao;
    private CourseDao courseDao;


    //private TextView grades_to_insert;
    private TextView output;
    private EditText insertName;
    private EditText insertScore;
    private EditText insertOutOf;
    private EditText insertGoalGrade;
    private Spinner gradeTypeSpinner;
    private ArrayAdapter<CharSequence> grade_adapter;
    private Button submitBtn;

    private int courseId;
    private int userId;


    HashMap<String, Double> gWeights = Assignment.gWeights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        assignmentDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getAssignmentDAO();

        courseDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getCourseDAO();

        Intent intent = getIntent();
        userId = intent.getIntExtra("userId", 1);
        courseId = intent.getIntExtra("courseId", 1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_grade);
        insertName = findViewById(R.id.assignmentNameEditText);
        insertScore = (EditText)findViewById(R.id.ScoreEditText);
        insertOutOf = (EditText)findViewById(R.id.OutOfEditText);
        gradeTypeSpinner = (Spinner)findViewById(R.id.spinner);

        grade_adapter = ArrayAdapter.createFromResource(this,
                R.array.assignment_type_array, android.R.layout.simple_spinner_item);

//        gradeTypeSpinner.getSelectedItem().toString();

        submitBtn = (Button)findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertToDatabase();

            }
        });

    }
    public void insertToDatabase() {


        double Score = Double.parseDouble(insertScore.getText().toString());
        double OutOf = Double.parseDouble(insertOutOf.getText().toString());
        String assignmentType = gradeTypeSpinner.getSelectedItem().toString();
        double assignmentWeightValue = 0;

        List<Course> courseWeights = courseDao.getUsersCourses(Integer.toString(userId));
        for(Course c: courseWeights) {
            if(assignmentType.equals( "Homework")) {
                assignmentWeightValue = c.getHwWeight();
                break;
            }
            else if(assignmentType.equals( "Test")) {
                assignmentWeightValue = c.getTestWeight();
            }
            else if(assignmentType.equals( "Quiz")) {
                assignmentWeightValue = c.getQuizWeight();
                break;
            }
            else if(assignmentType.equals( "Projects")) {
                assignmentWeightValue = c.getProjectWeight();
                break;
            }



        }

//        double weightedValue = gWeights.get(gradeTypeSpinner.getSelectedItem().toString());
        String name = insertName.getText().toString();
<<<<<<< HEAD
        assignmentDao.insert(new Assignment(OutOf, Score, courseId, userId, assignmentWeightValue, name));
        // getting all assignments to recalculate grade
=======
        assignmentDao.insert(new Assignment(OutOf, Score, courseId, userId, weightedValue, name));

        finish(); //takes user back to previoius activity


>>>>>>> 7ecd85767b29175dfbd07b24e1fc08d090c930b3
        List<Assignment> assignments = assignmentDao.getCourseAssignments(Integer.toString(courseId),
                                                                  Integer.toString(userId));

        // getting course to update grade
        Course course = courseDao.getCourseById(Integer.toString(courseId)).get(0);
        Double newGrade = Assignment.calculate(assignments);
        course.setCourseGrade(newGrade * 100.0); // makes percentage out of 100 instead of 1
        courseDao.update(course);
        finish();

    }




}