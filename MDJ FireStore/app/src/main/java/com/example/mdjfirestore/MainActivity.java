package com.example.mdjfirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtEmail;
    Button btnSend, btnFetch;
    FirebaseFirestore dbroot;
    TextView txtFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.edtEmail);
        edtName = findViewById(R.id.edtName);
        btnSend = findViewById(R.id.btnSend);
        btnFetch = findViewById(R.id.btnFetch);
        txtFetch = findViewById(R.id.txtFetch);

        dbroot = FirebaseFirestore.getInstance();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // for storing data in firestore
                insertdata();
            }
        });
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // for fetching data from firestore
                fetchdata();
            }
        });
    }


    public void insertdata() {
        // for inserting the values
        Map<String, String> items = new HashMap<>();
        items.put("name", edtName.getText().toString().trim());
        items.put("email",edtEmail.getText().toString().trim());

        dbroot.collection("students").add(items)  // add data to firestore
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        edtName.setText("");
                        edtEmail.setText("");
                        Toast.makeText(MainActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void fetchdata() {
        // here the path from where we can get the data
        DocumentReference document = dbroot.collection("students").document("Listdata");

        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                // our data is stored in documentSnapshot
                if (documentSnapshot.exists()){
                    // for fetching the data on textview
                    txtFetch.setText(documentSnapshot.getString("email")+" "+documentSnapshot.getString("name"));
                }else {
                    Toast.makeText(MainActivity.this, "Row not found", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}