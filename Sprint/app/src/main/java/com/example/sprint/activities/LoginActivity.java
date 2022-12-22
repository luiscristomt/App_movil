package com.example.sprint.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sprint.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText eTxt_emailLogin, eTxT_passwordLogin;
    private Button btn_loginLogin, btn_registerLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eTxt_emailLogin = (EditText) findViewById(R.id.eTxt_emailLogin);
        eTxT_passwordLogin = (EditText) findViewById(R.id.eTxt_passwordLogin);
        btn_loginLogin = (Button) findViewById(R.id.btn_loginLogin);
        btn_registerLogin = (Button) findViewById(R.id.btn_registerLogin);

        btn_loginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = eTxt_emailLogin.getText().toString();
                String password = eTxT_passwordLogin.getText().toString();
                FirebaseAuth mAuth;
                mAuth = FirebaseAuth.getInstance();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(getApplicationContext(), CatalogueActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
            }
        });
        btn_registerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}