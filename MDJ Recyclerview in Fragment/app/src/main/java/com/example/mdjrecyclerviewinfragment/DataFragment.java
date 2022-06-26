package com.example.mdjrecyclerviewinfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DataFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<DataModel>dataholder = new ArrayList<>();
    MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        dataholder.add(new DataModel(R.drawable.ic_launcher_background,"HR","Abhishek Maheriya"));
        dataholder.add(new DataModel(R.drawable.ic_launcher_background,"HR","Abhishek Maheriya"));
        dataholder.add(new DataModel(R.drawable.ic_launcher_background,"HR","Abhishek Maheriya"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyAdapter(getContext(),dataholder);
        recyclerView.setAdapter(adapter);



        return view;
    }
}