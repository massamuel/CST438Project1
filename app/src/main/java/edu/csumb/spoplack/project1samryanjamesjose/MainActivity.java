package edu.csumb.spoplack.project1samryanjamesjose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button insertButton,
            displayButton,
            updateButton,
            eligibleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertButton = (Button) findViewById(R.id.insertButton);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insertGrade =
                        new Intent(getApplicationContext(), InsertGradeActivity.class);
                startActivity(insertGrade);
            }
        });

        displayButton = (Button) findViewById(R.id.displayButton);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayGrades =
                        new Intent(getApplicationContext(), DisplayGradesActivity.class);
                startActivity(displayGrades);
            }
        });

        updateButton = (Button) findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateGrades =
                        new Intent(getApplicationContext(), UpdateGradesActivity.class);
                startActivity(updateGrades);
            }
        });

        eligibleButton = (Button) findViewById(R.id.eligibleButton);
        eligibleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eligibleGrades =
                        new Intent(getApplicationContext(), EligibleActivity.class);
                startActivity(eligibleGrades);
            }
        });
    }
}
