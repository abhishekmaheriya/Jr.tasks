package com.example.navlist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.Fragment;

public class DrawerBaseActivity extends MainActivity {
    ListView navLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_base);
        Toolbar toolbar = findViewById(R.id.toolbar);
        navLV = findViewById(R.id.navLV);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Camera", R.drawable.one));
        items.add(new Item("Gallery", R.drawable.eight));
        items.add(new Item("Manage", R.drawable.five));
        items.add(new Item("Share", R.drawable.nine));
        CustomAdapter adapter = new CustomAdapter(this, items);
        navLV.setAdapter(adapter);
        navLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawer.closeDrawers();
//                Toast.makeText(DrawerBaseActivity.this, items.get(position).getName(), Toast.LENGTH_LONG).show();
                if (position == 0){
                    changeFragment(new CamaraFragment());
                }else if (position == 1){
                    changeFragment(new GallaryFragment());
                }else if (position == 2){
                    changeFragment(new ManageFragment());
                }else if (position == 3){
                    changeFragment(new ShareFragment());
                }

//                Log.d(TAG, "onItemClick: " + items.get(position).getName());

            }
        });
    }

    private void changeFragment(Fragment fragment){
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fm.beginTransaction();
        fragmentTransaction.replace(R.id.framLayout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//
//    private void loadFragment(Fragment fragment) {
//// create a FragmentManager
//        FragmentManager fm = getFragmentManager();
//// create a FragmentTransaction to begin the transaction and replace the Fragment
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//// replace the FrameLayout with new Fragment
//        fragmentTransaction.replace(R.id.framLayout, fragment);
//        fragmentTransaction.commit(); // save the changes
//    }
}