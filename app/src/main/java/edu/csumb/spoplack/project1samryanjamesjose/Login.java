package edu.csumb.spoplack.project1samryanjamesjose;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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
 * Created by james on 2/16/2020.
 */

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;

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


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.lang.Boolean;
import java.util.regex.*;




public class Login extends AppCompatActivity implements OnClickListener{

    private TextView usrname;
    private EditText usrname1;
    private TextView passwd;
    private EditText passwd1;
    private Button login_butt;
    private UserDao myDao;
    private AppDatabase myDb;
    String getUsr;
    String getPwd;

    private Button cancel_login_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);

        usrname = (TextView) findViewById(R.id.log_text);
        usrname1 = (EditText) findViewById(R.id.edit_login);
        passwd = (TextView) findViewById(R.id.txt_pass);
        passwd1 = (EditText) findViewById(R.id.password_Input);



        login_butt = (Button) findViewById(R.id.loginButton);
        cancel_login_Button = (Button) findViewById(R.id.cancel_log);


        myDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.USER_TABLE)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        myDb.getUserDAO();


        login_butt.setOnClickListener(this);
        cancel_login_Button.setOnClickListener(this);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.loginButton:

                getUsr = usrname1.getText().toString();
                getPwd = passwd1.getText().toString();

             myDao.getAllUsers(getUsr, getPwd);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;







        }
    }











}


