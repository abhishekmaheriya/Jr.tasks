package com.example.recyclerviewwithviewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    TextView tvhomeTitle, tvhomeSubtitle;
    ImageView ivHome;
    ArrayList<Model> modelArrayList;
//    private static final String TAG = "HomeFragment";
    ViewPager viewPager;

    public HomeFragment() {
        this.modelArrayList = modelArrayList;
        this.viewPager = viewPager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tvhomeTitle = view.findViewById(R.id.tvHomeTitle);
        ivHome = view.findViewById(R.id.ivHome);
        tvhomeSubtitle = view.findViewById(R.id.tvHomeSubTitle);

        String message = getArguments().getString("Title");
        String msgSubtitle = getArguments().getString("subTitle");
        int images = getArguments().getInt("image");

        tvhomeTitle.setText(message);
        tvhomeSubtitle.setText(msgSubtitle);
        ivHome.setImageResource(images);

        return view;

    }
}