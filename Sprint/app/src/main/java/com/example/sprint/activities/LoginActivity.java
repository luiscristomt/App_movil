package com.example.sprint.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sprint.R;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_addition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CatalogueActivity.class);
                startActivity(intent);
            }
        });
        btn_addition = (Button) findViewById(R.id.btn_addition);
        btn_addition.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdditionActivity.class);
                startActivity(intent);
            }
        }));
    }
}