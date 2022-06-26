package com.example.tasknavigationandactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.activity_main,null,false);
        drawer.addView(v,0);
    }

    public void switchNew(View v){
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        startActivity(intent);

    }
}