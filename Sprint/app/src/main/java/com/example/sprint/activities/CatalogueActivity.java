package com.example.sprint.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.sprint.adapters.ProductAdapter;
import com.example.sprint.database.FirebaseDatabase;
import com.example.sprint.entities.ProductEntity;
import com.example.sprint.R;

import java.util.ArrayList;

public class CatalogueActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private GridView gridViewProducts;
    private ArrayList<ProductEntity> arrayProducts;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        gridViewProducts = (GridView) findViewById(R.id.lst_product);
        arrayProducts = new ArrayList<>();
        firebaseDatabase = new FirebaseDatabase();
        /*
        ProductEntity product_1 = new ProductEntity(R.drawable.domo,50000,"Cámara","Domo");
        ProductEntity product_2 = new ProductEntity(R.drawable.bala,250000,"Cámara", "Bala");
        ProductEntity product_3 = new ProductEntity(R.drawable.ptz,3750000,"Cámara","PTZ");
        ProductEntity product_4 = new ProductEntity(R.drawable.dvr,265000,"Equipo","DVR");

        firebaseDatabase.insertData(product_1);
        firebaseDatabase.insertData(product_2);
        firebaseDatabase.insertData(product_3);
        firebaseDatabase.insertData(product_4);

        arrayProducts.add(product_1);
        arrayProducts.add(product_2);
        arrayProducts.add(product_3);
        arrayProducts.add(product_4);
        */
        productAdapter = new ProductAdapter(this, arrayProducts);
        gridViewProducts.setAdapter(productAdapter);

        firebaseDatabase.getData(productAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_addProduct:
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_map:
                Intent intent1 = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}