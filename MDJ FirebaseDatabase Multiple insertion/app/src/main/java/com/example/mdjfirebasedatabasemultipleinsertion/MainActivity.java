package com.example.mdjfirebasedatabasemultipleinsertion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtRoll, edtCource,edtDuration;
    Button btnAdd;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference("Students");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtRoll = findViewById(R.id.edtRoll);
        edtCource = findViewById(R.id.edtCource);
        edtDuration = findViewById(R.id.edtDuration);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String roll = edtRoll.getText().toString().trim();
                String cource = edtCource.getText().toString().trim();
                String duration = edtDuration.getText().toString().trim();

                DataModel model = new DataModel(name,cource,duration);  // creating a model for getting multiple objects

                root.child(roll).setValue(model);  // here we set the roll as rootnode of other nodes

                edtName.setText("");
                edtCource.setText("");
                edtDuration.setText("");
                edtRoll.setText("");

                Toast.makeText(MainActivity.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}