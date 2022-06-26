package com.example.tasknavigationandactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MyBaseActivity extends AppCompatActivity {

    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_base);
        drawer = findViewById(R.id.drawer);
        navView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home){
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);

                }else if (id == R.id.setting){
                    Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);
                }else if(id == R.id.service){
                    Intent intent = new Intent(getApplicationContext(), FourthActivity.class);
                    startActivity(intent);
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        }) ;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


}