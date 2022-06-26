
package com.example.sqlitedatabasestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText searchEdt;
    TextView resultView;
    DbManager obj = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        searchEdt = findViewById(R.id.searchtxt);
        resultView = findViewById(R.id.txtResult);
    }

    public void SearchData(View view){
        if (!searchEdt.getText().toString().isEmpty()) {
            obj = new DbManager(this);
            Cursor result = obj.getdata(searchEdt.getText().toString());
            while (result.moveToNext()) {
                resultView.setText(result.getString(1) + " " + result.getString(2));
            }
        }else {
            searchEdt.setError("Please enter mobile no");
        }
    }
}