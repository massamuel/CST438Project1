package edu.csumb.spoplack.project1samryanjamesjose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import java.util.List;

import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;


/**
 * Created by james on 1/30/2020.
 */

// Incomplete so far

public class UserAccount extends AppCompatActivity{


    UserDao myDao;
    Button button1; //Used to create a user account
    Button button2; //Used to cancel
    EditText ed1, ed2; //

    TextView txt;
    int count = 3; //checks for login attempts





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        button1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        button2 = (Button)findViewById(R.id.button2);
        txt = (TextView)findViewById(R.id.textView3);
        txt.setVisibility(View.GONE);

        //Just a test

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")){



            }







        };






    }

}
