package com.example.recyclerviewwithviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewItemClick{
    RecyclerView recyclerView;
    ArrayList<Model> arrayList = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        arrayList.add(new Model(R.drawable.one,"Name","abhi"));
        arrayList.add(new Model(R.drawable.two,"Name","Abhishek"));
        arrayList.add(new Model(R.drawable.three,"Name","Krunal"));
        arrayList.add(new Model(R.drawable.one,"Name","Ani"));
        arrayList.add(new Model(R.drawable.two,"Name","Aaa"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
//        Toast.makeText(MainActivity.this, "Clicked"+position, Toast.LENGTH_SHORT).show();
        Snackbar.make(recyclerView, "You select"+arrayList.get(position).subTitle, Snackbar.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),ViewPagerActivity.class);
        intent.putExtra("data",arrayList);
        intent.putExtra("position",position);
        startActivity(intent);

        if (arrayList.get(position).subTitle.contains("abhi")){
            Snackbar.make(recyclerView, "It is in list "+arrayList.get(position).subTitle, Snackbar.LENGTH_LONG).show();
        }else{
            Snackbar.make(recyclerView, "It is not in list "+arrayList.get(position).subTitle, Snackbar.LENGTH_LONG).show();
        }

        if (arrayList.get(position).subTitle.equals("Abhishek")){
            Snackbar.make(recyclerView, "It is equals as object in list  "+arrayList.get(position).subTitle, Snackbar.LENGTH_LONG).show();
        }
    }
}