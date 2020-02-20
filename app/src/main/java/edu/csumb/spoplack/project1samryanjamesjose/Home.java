package edu.csumb.spoplack.project1samryanjamesjose;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


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
        login = (Button) findViewById(R.id.loginButton);

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


            case R.id.loginButton:{
                Toast.makeText(this, "not available yet", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(), Login.class);
//                startActivity(intent);
                break;

            }

        }


    }
}
