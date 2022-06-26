package com.example.taskfakeapiretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SubDataActivity extends AppCompatActivity {
    int pos;
    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
//    private int previousState, currentState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_data);
//        List<Model> modelList = (List<Model>)getIntent().getSerializableExtra("data");
//        Model modelList = (Model)getIntent().getSerializableExtra("data");

        viewPager = findViewById(R.id.viewpager);

        List<Model> modelListNew = (List<Model>)getIntent().getSerializableExtra("ModelData");

        System.out.println("modelListNew : - " + modelListNew);

        pos = getIntent().getIntExtra("position",0);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),modelListNew);
        viewPager.setAdapter(viewPagerAdapter); // set viewpager
        viewPager.setCurrentItem(pos);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

//                if (position == modelListNew.size() - 1) {
//                    viewPager.setCurrentItem(1, false);
//                }
//                else if (position == 0) {
//                    viewPager.setCurrentItem(modelListNew.size() - 2, false);
//                }
//
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                int currentPage = viewPager.getCurrentItem();       //ViewPager Type
//                if (currentPage == 20 || currentPage == 0){
//                    previousState = currentState;
//                    currentState = state;
//                    if (previousState == 1 && currentState == 0){
//
//                        viewPager.setCurrentItem(currentPage == 0 ? 20 : 0);
//
//                    }
//
//                }

//                if (state == ViewPager.SCROLL_STATE_IDLE) {
//                    int curr = viewPager.getCurrentItem();
//                    int lastReal = viewPager.getAdapter().getCount() ;
//                    if (curr == 0) {
//                        viewPager.setCurrentItem(lastReal, false);
//                    } else if (curr == lastReal) {
//                        viewPager.setCurrentItem(1, true);
//                    }
//                }

            }
        });
    }
}