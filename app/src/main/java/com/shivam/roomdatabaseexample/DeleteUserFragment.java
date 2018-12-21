package com.shivam.roomdatabaseexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteUserFragment extends Fragment {

    EditText txtid;
    Button delete;

    public DeleteUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete_user, container, false);
        txtid = (EditText) view.findViewById(R.id.txt_id);
        delete = (Button) view.findViewById(R.id.delete);
         delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 int id =  Integer.parseInt(txtid.getText().toString());

                 User user = new User();
                 user.setId(id);

                 MainActivity.myAppDatabase.myDao().deleteUser(user);

                 Toast.makeText(getActivity(), "User Deleted Successfully...", Toast.LENGTH_SHORT).show();

                 txtid.setText("");
             }
         });


        return view;
    }


}
