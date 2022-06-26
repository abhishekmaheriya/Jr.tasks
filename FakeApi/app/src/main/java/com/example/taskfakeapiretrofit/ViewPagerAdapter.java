package com.example.taskfakeapiretrofit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Model> list = new ArrayList<Model>();

    public ViewPagerAdapter(@NonNull FragmentManager fm, List<Model> mlist) {
        super(fm);
        list.addAll(mlist);
    }


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Title", list.get(position).getTitle());
        bundle.putString("price", list.get(position).getPrice()+"");
        bundle.putString("description", list.get(position).getDescription()+"");
        bundle.putString("category", list.get(position).getCategory()+"");
        bundle.putString("rating", list.get(position).getRating().getRate()+"");
        bundle.putString("image", list.get(position).getImage());
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
