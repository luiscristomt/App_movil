package com.example.sprint.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sprint.R;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText eTxt_emailRegister, eTxt_passwordRegister, eTxt_confirmationRegister;
    private Button btn_registerRegister;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eTxt_emailRegister = (EditText) findViewById(R.id.eTxt_emailRegister);
        eTxt_passwordRegister = (EditText) findViewById(R.id.eTxt_passwordRegister);
        eTxt_confirmationRegister = (EditText) findViewById(R.id.eTxt_confirmationRegister);
        btn_registerRegister =(Button) findViewById(R.id.btn_registerRegister);

        btn_registerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = eTxt_emailRegister.getText().toString();
                String password = eTxt_passwordRegister.getText().toString();
                String confirmation = eTxt_confirmationRegister.getText().toString();

                if (password.compareTo(confirmation) == 0){
                    FirebaseAuth mAuth;
                    // ...
                    // Initialize Firebase Auth
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email, password);
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}