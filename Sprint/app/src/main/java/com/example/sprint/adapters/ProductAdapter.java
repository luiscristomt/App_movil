package com.example.sprint.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sprint.R;
import com.example.sprint.activities.AddActivity;
import com.example.sprint.activities.CatalogueActivity;
import com.example.sprint.database.FirebaseDatabase;
import com.example.sprint.entities.ProductEntity;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<ProductEntity> arrayProduct;

    public ProductAdapter(Context context, ArrayList<ProductEntity> arrayProduct) {
        this.context = context;
        this.arrayProduct = arrayProduct;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<ProductEntity> getArrayProduct() {
        return arrayProduct;
    }

    public void setArrayProduct(ArrayList<ProductEntity> arrayProduct) {
        this.arrayProduct = arrayProduct;
    }

    @Override
    public int getCount() {
        return arrayProduct.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProduct.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.format_product, null);

        ProductEntity productEntity = arrayProduct.get(i);

        ImageView img_product = (ImageView) view.findViewById(R.id.img_product);
        TextView vTxt_nameProduct = (TextView) view.findViewById(R.id.vTxt_nameProduct);
        TextView vTxt_descriptionProduct = (TextView) view.findViewById(R.id.vtxt_descriptionProduct);
        TextView vTxt_priceProduct = (TextView) view.findViewById(R.id.vTxt_priceProduct);
        Button btn_updateProduct = (Button) view.findViewById(R.id.btn_updateProduct);
        Button btn_deleteProduct = (Button) view.findViewById(R.id.btn_deleteProduct);

        img_product.setImageResource(productEntity.getImg_product());
        vTxt_nameProduct.setText(productEntity.getvTxt_nameProduct());
        vTxt_descriptionProduct.setText(productEntity.getvTxt_descriptionProduct());
        vTxt_priceProduct.setText(String.valueOf(productEntity.getvTxt_priceProduct()));
        btn_updateProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddActivity.class);
                intent.putExtra("edit", true);
                intent.putExtra("image", productEntity.getImg_product());
                intent.putExtra("price", String.valueOf(productEntity.getvTxt_priceProduct()));
                intent.putExtra("name", productEntity.getvTxt_nameProduct());
                intent.putExtra("description", productEntity.getvTxt_descriptionProduct());
                context.startActivity(intent);
            }
        });
        btn_deleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase firebaseDatabase = new FirebaseDatabase();
                firebaseDatabase.deleteData(productEntity.getvTxt_nameProduct());
                Intent intent = new Intent(context, CatalogueActivity.class);
                context.startActivity(intent);
            }
        });
        return view;
    }
}