package com.example.proyecto.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.proyecto.R;
import com.example.proyecto.adapters.ProductAdapter;
import com.example.proyecto.entities.ProductEntity;

import java.util.ArrayList;

public class CatalogueActivity extends AppCompatActivity {

    private GridView gridViewProducts;
    private ArrayList<ProductEntity> arrayProducts;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        gridViewProducts = (GridView) findViewById(R.id.lst_product);
        arrayProducts = new ArrayList<>();
        ProductEntity product_1 = new ProductEntity(R.drawable.domo,50000,"Cámara","Domo");
        ProductEntity product_2 = new ProductEntity(R.drawable.bala,250000,"Cámara", "Bala");
        ProductEntity product_3 = new ProductEntity(R.drawable.ptz,3750000,"Cámara","PTZ");
        ProductEntity product_4 = new ProductEntity(R.drawable.dvr,265000,"Equipo","DVR");
        arrayProducts.add(product_1);
        arrayProducts.add(product_2);
        arrayProducts.add(product_3);
        arrayProducts.add(product_4);
        productAdapter = new ProductAdapter(this, arrayProducts);
        gridViewProducts.setAdapter(productAdapter);
    }
}