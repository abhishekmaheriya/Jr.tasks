package com.example.sqlitedatabasestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {
    EditText name, email, mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        name = findViewById(R.id.t1);
        email = findViewById(R.id.t2);
        mobile = findViewById(R.id.t3);

    }
    public void addRecord(View view) {
        DbManager db = new DbManager(this);

        if (!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !mobile.getText().toString().isEmpty()) {
            String res = db.addRecord(name.getText().toString(), email.getText().toString(), mobile.getText().toString());
            Toast.makeText(this, "" + res, Toast.LENGTH_SHORT).show();

            // after inserting the data editbox will empty
            name.setText("");
            email.setText("");
            mobile.setText("");
        } else if (name.getText().toString().isEmpty()) {
            name.setError("Please enter name");

        } else if (email.getText().toString().isEmpty()) {
            email.setError("Please enter email");

        } else if (mobile.getText().toString().isEmpty()) {
            mobile.setError("Please enter mobile");
        }
    }
}