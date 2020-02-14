package edu.csumb.spoplack.project1samryanjamesjose;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import edu.csumb.spoplack.project1samryanjamesjose.Activities.*;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.User;
import edu.csumb.spoplack.project1samryanjamesjose.R;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDao;
import edu.csumb.spoplack.project1samryanjamesjose.Database.User.UserDatabase;




/**
 * A simple {@link Fragment} subclass.
 */
public class addUserFragment extends Fragment {
    private EditText userId, firstName, lastName, password;
    private Button bn_create;



    public addUserFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        userId = view.findViewById(R.id.user_id);
        firstName = view.findViewById(R.id.first_name);
        lastName = view.findViewById(R.id.last_name);
        password = view.findViewById(R.id.pass_word);
        bn_create = view.findViewById(R.id.bn_createAccount);

        bn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userid = Integer.parseInt(userId.getText().toString());
                String first = firstName.getText().toString();
                String last = lastName.getText().toString();
                String pass = password.getText().toString();

                User user = new User(userid,pass,first, last);
                edu.csumb.spoplack.project1samryanjamesjose.Activities.MainActivity.myDb.getUserDAO().insert(user);

                Toast.makeText(getActivity(), "Account created succesfully!", Toast.LENGTH_SHORT).show();

                userId.setText("");
                firstName.setText("");
                lastName.setText("");
                password.setText("");


            }
        });


        return view;
    }

}
