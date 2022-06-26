package com.example.mdjfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getSupportFragmentManager().getFragments() != null && getSupportFragmentManager().getFragments().size() > 0){
                    for (int i = 0; i<getSupportFragmentManager().getFragments().size(); i++){
                        Fragment fragment = getSupportFragmentManager().getFragments().get(i);
                        if (fragment != null){
                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        }
                    }
                }
                updateFragment(new BlankFragment());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getSupportFragmentManager().getFragments() != null && getSupportFragmentManager().getFragments().size() > 0){
                    for (int i = 0; i<getSupportFragmentManager().getFragments().size(); i++){
                        Fragment fragment = getSupportFragmentManager().getFragments().get(i);
                        if (fragment != null){
                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        }
                    }
                }
                updateFragment(new BlankFragment2());
            }
        });
    }

    public void updateFragment(Fragment fragment){
        FragmentManager frm = getSupportFragmentManager();
        FragmentTransaction frt = frm.beginTransaction();
        frt.add(R.id.wrapper,fragment);
        frt.addToBackStack(null);
        frt.commit();
    }
}