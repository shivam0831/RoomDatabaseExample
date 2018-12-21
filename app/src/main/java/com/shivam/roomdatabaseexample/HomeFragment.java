package com.shivam.roomdatabaseexample;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    Button btnAddUser, btnReadUser, btnDelete , btnUpdate;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnAddUser = view.findViewById(R.id.btn_add_user);
        btnReadUser = view.findViewById(R.id.btn_view_user);
        btnDelete = view.findViewById(R.id.btn_delete_user);
        btnUpdate = view.findViewById(R.id.btn_update_user);


        btnAddUser.setOnClickListener(this);
        btnReadUser.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment()).
                        addToBackStack(null).commit();
                break;
            case R.id.btn_view_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadUsersFragment()).
                        addToBackStack(null).commit();
                break;
            case R.id.btn_delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteUserFragment()).
                        addToBackStack(null).commit();
                break;
            case R.id.btn_update_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateUserFragment()).
                        addToBackStack(null).commit();
                break;
        }
    }
}
