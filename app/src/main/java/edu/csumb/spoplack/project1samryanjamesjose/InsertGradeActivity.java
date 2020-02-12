package edu.csumb.spoplack.project1samryanjamesjose;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;

public class InsertGradeActivity extends AppCompatActivity {

    private AssignmentDao assignmentDao;
    //private TextView grades_to_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_grade);
    }
    public void insertToDatabase() {
        //assignmentDao.insert(new Assignment());
    }



}
