package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import edu.csumb.spoplack.project1samryanjamesjose.Adpaters.AssignmentAdapter;
import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;

import android.os.Bundle;

import java.util.ArrayList;

public class AssignmentActivity extends AppCompatActivity {

    private AssignmentDao mAssignmentDao;

    private RecyclerView recyclerView;
    private AssignmentAdapter assignmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        mAssignmentDao =  Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getAssignmentDAO();

        ArrayList<Assignment> userAssignments = (ArrayList<Assignment>) mAssignmentDao.getAllAssignments();
        assignmentAdapter = new AssignmentAdapter(userAssignments);

        recyclerView = findViewById(R.id.rvAssignments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(assignmentAdapter);

        if(userAssignments.isEmpty()) {
            Assignment cst438 = new Assignment(10, 9, 438, 1234, 400);

            mAssignmentDao.insert(cst438);
            assignmentAdapter.notifyItemInserted(0);
        }
    }
}
