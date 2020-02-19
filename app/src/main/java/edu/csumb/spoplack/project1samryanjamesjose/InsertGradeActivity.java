package edu.csumb.spoplack.project1samryanjamesjose;

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
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;

public class InsertGradeActivity extends AppCompatActivity {

    public static HashMap<String,Double> gWeights = new HashMap<String, Double>();

    private AssignmentDao assignmentDao;
    //private TextView grades_to_insert;
    private TextView output;
    private EditText insertScore;
    private EditText insertOutOf;
    private EditText insertGoalGrade;
    private Spinner gradeTypeSpinner;
    private ArrayAdapter<CharSequence> grade_adapter;
    private Button submitBtn;
    private double weightedValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gWeights.put("Homework",35.0);
        gWeights.put("Test",35.0);
        gWeights.put("Projects",25.0);
        gWeights.put("Quiz",5.0);

        assignmentDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getAssignmentDAO();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_grade);
        insertScore = (EditText)findViewById(R.id.ScoreEditText);
        insertOutOf = (EditText)findViewById(R.id.OutOfEditText);
        insertGoalGrade = (EditText)findViewById(R.id.goalGradeText);
        output = (TextView)findViewById(R.id.outputText);
        gradeTypeSpinner = (Spinner)findViewById(R.id.spinner);

        grade_adapter = ArrayAdapter.createFromResource(this,
                R.array.assignment_type_array, android.R.layout.simple_spinner_item);

//        gradeTypeSpinner.getSelectedItem().toString();

        weightedValue = gWeights.get(gradeTypeSpinner.getSelectedItem().toString());

        submitBtn = (Button)findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double goalGrade = Double.parseDouble(insertGoalGrade.getText().toString());
                double scoreOnAssignment = Double.parseDouble(insertScore.getText().toString());
                double scoreOutOfAssignment = Double.parseDouble(insertOutOf.getText().toString());

                double calculation = (goalGrade - scoreOnAssignment/scoreOutOfAssignment) * 1 - weightedValue/weightedValue;
//                AlertDialog calculatedDialogue = new AlertDialog.Builder(InsertGradeActivity.this).create();
//                calculatedDialogue.setTitle("Grade caluclated!");
//                calculatedDialogue.setMessage("Your grade needed to get GOAL is: " );
                //Required = (Goal − Current × (100% − Final Weight)) / Final Weight
//                (Goal - Current * (1 - weight ))/weight

//                calculatedDialogue.show();
                output.setText("You would need "  + Double.toString(calculation) + " On future assginments (calculated) to pass this ");
            }
        });

    }
//    public void insertToDatabase() {
//        //assignmentDao.insert(new Assignment());
//        double Score = Double.parseDouble(insertScore.getText().toString());
//        double OutOf = Double.parseDouble(insertOutOf.getText().toString());
//        assignmentDao.insert(new Assignment(Score,OutOf));
//
//    }



}