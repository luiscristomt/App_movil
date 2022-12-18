package com.example.sprint.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sprint.R;

public class AdditionActivity extends AppCompatActivity {

    private EditText eTxt_number1, eTxt_number2, eTxt_result;
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        eTxt_number1 = (EditText) findViewById(R.id.eTxt_number1);
        eTxt_number2 = (EditText) findViewById(R.id.eTxt_number2);
        eTxt_result = (EditText) findViewById(R.id.eTxt_result);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eTxt_result.setText(String.valueOf(Float.parseFloat(eTxt_number1.getText().toString().trim()) + Float.parseFloat(eTxt_number2.getText().toString().trim())));
            }
        });
    }
}