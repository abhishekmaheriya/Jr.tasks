package com.example.mdjsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtPassword;
    Button btnSave, btnDelete;
    TextView tvResult , tvResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPass);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        tvResult = findViewById(R.id.tvResult);
        tvResult2 = findViewById(R.id.tvResult2);

        checkedExistedRecords();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("credentials",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", edtName.getText().toString());
                editor.putString("password", edtPassword.getText().toString());
                editor.apply();
                tvResult.setText("");
                tvResult2.setText("");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("credentials",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                tvResult.setText("");
                tvResult2.setText("");

                tvResult.setText("Deleted Successfully");
                tvResult.setTextColor(Color.GREEN);
            }
        });
    }
    public void checkedExistedRecords(){
        SharedPreferences preferences = getSharedPreferences("credentials",MODE_PRIVATE);
        if (preferences.contains("username") ){
            tvResult.setText(preferences.getString("username" , ""));
            tvResult2.setText(preferences.getString("password" , ""));

        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}