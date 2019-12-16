package com.example.discover.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.discover.model.Controller;
import com.example.discover.adapters.MyAdapter;
import com.example.discover.model.Post;
import com.example.discover.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private Controller controller;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutmanager;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.my_recycler_view);

        controller = new Controller(this);
        controller.start();





        //*button.setOnClickListener(new View.OnClickListener(){
            //@Override
            //public void onClick(View v) {
              //  controller.onClickedButton();
            //}
        //})

        return view;
    }

    public void showList(List< Post > changesList) {

        layoutmanager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutmanager);

        mAdapter = new MyAdapter(changesList);
        recyclerView.setAdapter(mAdapter);

    }

    public void showError() {
        Toast.makeText(getContext(), "Echec de connexion", Toast.LENGTH_SHORT).show();
    }
}
