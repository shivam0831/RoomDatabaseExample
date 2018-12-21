package com.shivam.roomdatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    EditText id,name,email;
    Button btnSave;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_user, container, false);

        id = (EditText) view.findViewById(R.id.txt_user_id);
        name = (EditText) view.findViewById(R.id.txt_user_name);
        email = (EditText) view.findViewById(R.id.txt_user_email);
        btnSave = (Button) view.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int userid =  Integer.parseInt(id.getText().toString());
                String username = name.getText().toString();
                String useremail = email.getText().toString();

                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User Added Successfully...", Toast.LENGTH_SHORT).show();

                id.setText("");
                name.setText("");
                email.setText("");
            }
        });


        return view;

    }

}
