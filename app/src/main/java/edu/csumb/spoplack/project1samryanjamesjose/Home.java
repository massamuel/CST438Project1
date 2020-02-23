package edu.csumb.spoplack.project1samryanjamesjose;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.app.Activity;
import android.widget.Toast;
import android.view.View;


import androidx.room.Database;
import edu.csumb.spoplack.project1samryanjamesjose.Activities.MainActivity;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;

import edu.csumb.spoplack.project1samryanjamesjose.Adpaters.CoursesAdapter;
import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.Course;
import edu.csumb.spoplack.project1samryanjamesjose.Database.Course.CourseDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;


/**
 * Created by james on 2/18/2020.
 */

public class Home extends AppCompatActivity implements OnClickListener {

    private Button createUser;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        createUser = (Button) findViewById(R.id.startCreateButton);
        login = (Button) findViewById(R.id.login_Button);

        login.setOnClickListener(this);
        createUser.setOnClickListener(this);

    }


    public void onClick(View v){

        switch(v.getId()){
            case R.id.startCreateButton:{

                Intent intent = new Intent(getApplicationContext(), CreateAccount.class);
                startActivity(intent);
                break;


            }


            case R.id.login_Button:{
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                break;

            }

        }


    }
}
