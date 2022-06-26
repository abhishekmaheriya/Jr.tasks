package com.example.mdjfirebaseusermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtPassword,edtEmail;
    Button  btnSignUp;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPass);
        edtEmail = findViewById(R.id.edtEmail);
        btnSignUp = findViewById(R.id.btnSignup);
        progressBar = findViewById(R.id.progressBar);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edtName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                mAuth= FirebaseAuth.getInstance();
            }
        });

    }
}