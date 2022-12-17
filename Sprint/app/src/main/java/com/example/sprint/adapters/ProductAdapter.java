package com.example.sprint.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sprint.R;
import com.example.sprint.entities.ProductEntity;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<ProductEntity> arrayProduct;

    public ProductAdapter(Context context, ArrayList<ProductEntity> arrayProduct) {
        this.context = context;
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
        ImageView img_product = (ImageView) view.findViewById(R.id.img_product);
        TextView vTxt_nameProduct = (TextView) view.findViewById(R.id.vTxt_nameProduct);
        TextView vTxt_descriptionProduct = (TextView) view.findViewById(R.id.vtxt_descriptionProduct);
        TextView vTxt_priceProduct = (TextView) view.findViewById(R.id.vTxt_priceProduct);
        ProductEntity product = arrayProduct.get(i);
        img_product.setImageResource(product.getImg_product());
        vTxt_nameProduct.setText(product.getvTxt_nameProduct());
        vTxt_descriptionProduct.setText(product.getvTxt_descriptionProduct());
        vTxt_priceProduct.setText(String.valueOf(product.getvTxt_priceProduct()));
        return view;
    }
}