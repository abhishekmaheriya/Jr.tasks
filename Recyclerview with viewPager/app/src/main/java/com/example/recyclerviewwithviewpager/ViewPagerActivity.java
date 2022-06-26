package com.example.recyclerviewwithviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.viewpager);

        ArrayList<Model> modelArrayList = (ArrayList<Model>) getIntent().getSerializableExtra("data");
        pos = getIntent().getIntExtra("position",0);

//        System.out.println("Number List :- "+ modelArrayList.toString());
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),modelArrayList);

        //add fragments
//        viewPagerAdapter.add(new SecondFragment(modelArrayList,viewPager));
//        viewPagerAdapter.add(new ThirdFragment(modelArrayList,viewPager));

        viewPager.setAdapter(viewPagerAdapter); // set viewpager

        viewPager.setCurrentItem(pos); // for set the position of item


    }
}