package edu.csumb.spoplack.project1samryanjamesjose;

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

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;

public class InsertGradeActivity extends AppCompatActivity {


    private AssignmentDao assignmentDao;
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


//                AlertDialog calculatedDialogue = new AlertDialog.Builder(InsertGradeActivity.this).create();
//                calculatedDialogue.setTitle("Grade caluclated!");
//                calculatedDialogue.setMessage("Your grade needed to get GOAL is: " );
                //Required = (Goal − Current × (100% − Final Weight)) / Final Weight
//                (Goal - Current * (1 - weight ))/weight

//                calculatedDialogue.show();

                insertToDatabase();

            }
        });

    }
    public void insertToDatabase() {
        //assignmentDao.insert(new Assignment());
        double Score = Double.parseDouble(insertScore.getText().toString());
        double OutOf = Double.parseDouble(insertOutOf.getText().toString());
        double weightedValue = gWeights.get(gradeTypeSpinner.getSelectedItem().toString());
        String name = insertName.getText().toString();
        assignmentDao.insert(new Assignment(OutOf, Score, courseId, userId, weightedValue, name));
        finish();

    }



}