package com.example.recyclerviewwithviewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Model> list = new ArrayList<Model>();
//    ViewPager viewPager;

    public ViewPagerAdapter(@NonNull FragmentManager fm, ArrayList<Model> modelArrayList) {
        super(fm);
        list.addAll(modelArrayList);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Title", list.get(position).title);
        bundle.putString("subTitle", list.get(position).subTitle);
        bundle.putInt("image", list.get(position).img);
        homeFragment.setArguments(bundle);
        return homeFragment;

    }

    @Override
    public int getCount() {
        return list.size();
    }

}


