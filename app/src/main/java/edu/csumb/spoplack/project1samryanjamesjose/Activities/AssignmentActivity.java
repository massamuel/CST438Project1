package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

//import android.support.design.widget.FloatingActionButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.csumb.spoplack.project1samryanjamesjose.Adpaters.AssignmentAdapter;
import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.Assignment;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Assignment.AssignmentDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;

public class AssignmentActivity extends AppCompatActivity {

    private AssignmentDao mAssignmentDao;

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private AssignmentAdapter assignmentAdapter;
    private ArrayList<Assignment> userAssignments;

    private int userId;
    private int courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        Intent intent = getIntent();
        userId = intent.getIntExtra("userId", 1);
        courseId = intent.getIntExtra("courseId", 1);

        mAssignmentDao =  Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DBNAME)
                .allowMainThreadQueries()
                .build()
                .getAssignmentDAO();


        updateList();

        if(userAssignments.isEmpty()) {
            Toast.makeText(this, "No assignments yet", Toast.LENGTH_LONG).show();
        }

        fab = findViewById(R.id.fabInsertGrade);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssignmentActivity.this, InsertGradeActivity.class);
                intent.putExtra("userId", userId);
                intent.putExtra("courseId", courseId);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        updateList();
    }

    private void updateList() {
        userAssignments =
                (ArrayList<Assignment>) mAssignmentDao.getCourseAssignments(Integer.toString(courseId),
                        Integer.toString(userId));
        assignmentAdapter = new AssignmentAdapter(userAssignments);

        recyclerView = findViewById(R.id.rvAssignments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(assignmentAdapter);
    }
}
