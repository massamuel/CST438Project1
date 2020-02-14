package edu.csumb.spoplack.project1samryanjamesjose;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;

public class DisplayGradesActivity extends AppCompatActivity {

    private View displayView;
    private View otherView;
    private AssignmentDao assignmentDao;

    private List<Assignment> selectedAssignments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_grades);
    }

    public void resetDisplay() {
//        selectedAssignments = assignmentDao.FindAssignmentById(id);

    }
}
