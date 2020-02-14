package edu.csumb.spoplack.project1samryanjamesjose;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.csumb.spoplack.project1samryanjamesjose.Activities.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button bn_Login;
    private Button bn_add_user;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bn_add_user = view.findViewById(R.id.bn_createAccount);
        bn_add_user.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.bn_createAccount:
                edu.csumb.spoplack.project1samryanjamesjose.Activities.MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new addUserFragment()).addToBackStack(null).commit();
                break;



        }

    }
}
