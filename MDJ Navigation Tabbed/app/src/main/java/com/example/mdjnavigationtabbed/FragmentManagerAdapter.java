package com.example.mdjnavigationtabbed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentManagerAdapter extends FragmentPagerAdapter {
    private int tabNo;
    public FragmentManagerAdapter(@NonNull FragmentManager fm, int behavior, int tabNo) {
        super(fm, behavior);
        this.tabNo = tabNo;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Fragment1();
            case 1: return new Fragment2();
            case 2: return new Fragment3();

            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabNo;
    }
}
