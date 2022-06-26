package com.example.sqlitedatabasestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startdbapp(View view){
        new DbManager(this);
        startActivity(new Intent(this, InsertData.class));
    }

    public void gotonextpage(View view){
        startActivity(new Intent(this,MainActivity2.class));
    }
}