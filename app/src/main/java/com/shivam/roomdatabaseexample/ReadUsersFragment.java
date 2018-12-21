package com.shivam.roomdatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUsersFragment extends Fragment {

     private TextView txtInfo;

    public ReadUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_users, container, false);
        txtInfo = view.findViewById(R.id.txt_dispaly_info);

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();
        String info = "";
        for (User user : users)
        {
            int id = user.getId();
            String name= user.getName();
            String email = user.getEmail();

            info = info+"\n\n"+"Id : "+id+"\n"+"Name : "+name+"\n"+"Email :"+email;
        }
        txtInfo.setText(info);
        return view;
    }

}
