package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;

/**
 * Created by james on 2/16/2020.
 */




public class CreateAccountActivity extends AppCompatActivity implements OnClickListener {

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
                user = myDao.getAllUsers(userN, pass).get(0);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder
                        .setMessage("Account has been created succesfully for "+username1.getText().toString())
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
//<<<<<<< HEAD:app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/CreateAccount.java
                                Intent intent = new Intent(getApplicationContext(), Home.class);
//=======
                                Intent intent = new Intent(CreateAccountActivity.this, CoursesActivity.class);
                                intent.putExtra("userId", user.getUserId());
//>>>>>>> ed74dec8d5a08c4372b7b9f5d62d867c43ac47de:app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/Activities/CreateAccountActivity.java
                                startActivity(intent);
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();



            }
            break;

            case R.id.cancel_Button: {
                //if cancel then go back to homepage, which will be LoginActivity.class once finished

                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);
                break;
            }
        }
    }


}
