package com.example.mdjnavigationtabbed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem tab1, tab2, tab3;
    ViewPager viewPager;
    FragmentManagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.mydrawer);
        navigationView = findViewById(R.id.cnav);
        toolbar = findViewById(R.id.custom_toolbar);
        tabLayout = findViewById(R.id.ctablayout);
        tab1 = findViewById(R.id.ctab1);
        tab2 = findViewById(R.id.ctab2);
        tab3 = findViewById(R.id.ctab3);
        viewPager = findViewById(R.id.pageholder);

        setTitle("Abhi's Messenger");
        setSupportActionBar(toolbar); // for setting of title

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        adapter = new FragmentManagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
 
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.homeMenu){
                    Toast.makeText(MainActivity.this, "You pressed Home", Toast.LENGTH_SHORT).show();
                }else if (item.getItemId() == R.id.settingMenu){
                    Toast.makeText(MainActivity.this, "You Pressed Setting", Toast.LENGTH_SHORT).show();
                }else if (item.getItemId() == R.id.photoMenu){
                    Toast.makeText(MainActivity.this, "You Pressed Photos", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }
}