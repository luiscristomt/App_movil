package com.example.sprint.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sprint.R;
import com.example.sprint.database.FirebaseDatabase;
import com.example.sprint.entities.ProductEntity;

public class AdditionActivity extends AppCompatActivity {

    private EditText eTxt_nameProductAdd, eTxt_descriptionProductAdd, eTxt_priceProductAdd;
    private Button btn_add;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        eTxt_nameProductAdd = (EditText) findViewById(R.id.eTxt_nameProductAdd);
        eTxt_descriptionProductAdd = (EditText) findViewById(R.id.eTxt_descriptionProductAdd);
        eTxt_priceProductAdd = (EditText) findViewById(R.id.eTxt_priceProductAdd);
        btn_add = (Button) findViewById(R.id.btn_add);
        firebaseDatabase = new FirebaseDatabase();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductEntity productEntity = new ProductEntity(
                        R.drawable.domo,
                        Integer.parseInt(eTxt_priceProductAdd.getText().toString()),
                        eTxt_nameProductAdd.getText().toString(),
                        eTxt_descriptionProductAdd.getText().toString()
                );
                firebaseDatabase.insertData(productEntity);
                Intent intent = new Intent(getApplicationContext(), CatalogueActivity.class);
                startActivity(intent);
            }
        });
    }
}