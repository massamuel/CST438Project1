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
import java.util.regex.*;




public class CreateAccount extends AppCompatActivity implements OnClickListener {

    private TextView username;
    private EditText username1;
    private TextView password;
    private EditText password1;
    private TextView first;
    private EditText firstn;
    private TextView last;
    private EditText lastn;
    private UserDao myDao;


    String userN;
    String pass;
    String firstName;
    String lastName;
    public static User user;

    private Button createuserButton;
    private Button createCancelButton;
    private String match;
    private  int counter =0;
    public  ArrayList<String> usernameList = new ArrayList<String>();

    private int  id=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        username = (TextView) findViewById(R.id.user_text);
        username1 = (EditText) findViewById(R.id.enter_user);
        first = (TextView) findViewById(R.id.firstN_textview);
        firstn = (EditText) findViewById(R.id.edit_firstN);
        last = (TextView) findViewById(R.id.lastN_textview);
        lastn = (EditText) findViewById(R.id.lastN_edit);
        password = (TextView) findViewById(R.id.password_textview);
        password1 = (EditText) findViewById(R.id.create_Pass);
        createuserButton = (Button) findViewById(R.id.createuserButton);
        createCancelButton = (Button) findViewById(R.id.cancel_Button);


        createuserButton.setOnClickListener(this);
        createCancelButton.setOnClickListener(this);
        myDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.USER_TABLE)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        match = "^(?=.*[0-9])(?=.*[a-z-A-Z]{3}).*$";



    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.createuserButton:{
                userN = username1.getText().toString();
                pass = password1.getText().toString();
                firstName = firstn.getText().toString();
                lastName = lastn.getText().toString();

                user = new User(userN, pass, firstName, lastName);

                myDao.insert(user);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder
                        .setMessage("Account has been created succesfully for "+username1.getText().toString())
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                CreateAccount.this.finish();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();



            }
            break;

            case R.id.cancel_Button: {
                //if cancel then go back to homepage, which will be Login.class once finished

                Intent intent = new Intent(getApplicationContext(), CreateAccount.class);
                startActivity(intent);
                break;
            }
        }
    }


}
