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
public class UpdateUserFragment extends Fragment {

    EditText id,name,email;
    Button btnUpdate;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_user, container, false);

        id = (EditText) view.findViewById(R.id.txt_user_id);
        name = (EditText) view.findViewById(R.id.txt_user_name);
        email = (EditText) view.findViewById(R.id.txt_user_email);
        btnUpdate = (Button) view.findViewById(R.id.btn_update);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int userid =  Integer.parseInt(id.getText().toString());
                String username = name.getText().toString();
                String useremail = email.getText().toString();

                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(), "User Updated...", Toast.LENGTH_SHORT).show();

                id.setText("");
                name.setText("");
                email.setText("");
            }
        });



        return view;
    }

}
