//app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/Login.java
package edu.csumb.spoplack.project1samryanjamesjose.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import edu.csumb.spoplack.project1samryanjamesjose.Activities.CoursesActivity;
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

//package edu.csumb.spoplack.project1samryanjamesjose.Activities;
//>>>>>>> ed74dec8d5a08c4372b7b9f5d62d867c43ac47de:app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/Activities/LoginActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//<<<<<<< HEAD:app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/Login.java
import android.widget.TextView.OnEditorActionListener;
import android.app.Activity;
import android.widget.Toast;
import java.util.List;

//>>>>>>> ed74dec8d5a08c4372b7b9f5d62d867c43ac47de:app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/Activities/LoginActivity.java

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import edu.csumb.spoplack.project1samryanjamesjose.Database.AppDatabase;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;
import edu.csumb.spoplack.project1samryanjamesjose.R;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;


/**
 * Created by james on 2/16/2020.
 */


//<<<<<<< HEAD:app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/Login.java
public class Login extends AppCompatActivity implements OnClickListener {
public class LoginActivity extends AppCompatActivity implements OnClickListener{
//>>>>>>> ed74dec8d5a08c4372b7b9f5d62d867c43ac47de:app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/Activities/LoginActivity.java

    private TextView usrname;
    private EditText usrname1;
    private TextView passwd;
    private EditText passwd1;
    private Button login_butt;
    private UserDao myDao;
    private AppDatabase myDb;
    User user;
    String getUsr;
    String getPwd;
    List<User> Users;

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

        // myDb.getUserDAO();


        login_butt.setOnClickListener(this);
        cancel_login_Button.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton: {

                getUsr = usrname1.getText().toString();
                getPwd = passwd1.getText().toString();


             myDao.getAllUsers(getUsr, getPwd);
                Intent intent = new Intent(getApplicationContext(), CoursesActivity.class);
                startActivity(intent);
                break;
//>>>>>>> ed74dec8d5a08c4372b7b9f5d62d867c43ac47de:app/src/main/java/edu/csumb/spoplack/project1samryanjamesjose/Activities/LoginActivity.java



                Users = myDao.getAllUsers(getUsr, getPwd);

                if(Users.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "User Login Failed", Toast.LENGTH_SHORT);
                    toast.show();

                }
                else {

                    Users.equals(Users.get(0));
                    Intent i = new Intent(getApplicationContext(), CoursesActivity.class);
                    startActivity(i);
                    break;





                }










            }
            case R.id.cancel_log:{
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                break;

            }
        }
    }
}














