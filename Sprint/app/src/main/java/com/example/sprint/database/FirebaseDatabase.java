package com.example.sprint.database;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.sprint.adapters.ProductAdapter;
import com.example.sprint.entities.ProductEntity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDatabase {

    private FirebaseFirestore db;

    public FirebaseDatabase(){
        this.db = FirebaseFirestore.getInstance();
    }

    public void insertData(ProductEntity productEntity){
        
        Map<String, Object> product = new HashMap<>();
        product.put("image",productEntity.getImg_product());
        product.put("price", productEntity.getvTxt_priceProduct());
        product.put("name", productEntity.getvTxt_nameProduct());
        product.put("description", productEntity.getvTxt_descriptionProduct());

        db.collection("products")
                .add(product)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    public void getData(ProductAdapter productAdapter){
        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<ProductEntity> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ProductEntity product = new ProductEntity(
                                        Integer.parseInt(document.getData().get("image").toString()),
                                        Integer.parseInt(document.getData().get("price").toString()),
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString()
                                    );
                                list.add(product);
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                            productAdapter.setArrayProduct(list);
                            productAdapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void updateDate(ProductEntity productEntity){
        db.collection("products").whereEqualTo("name", productEntity.getvTxt_nameProduct())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<ProductEntity> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                document.getReference().update(
                                        "image", productEntity.getImg_product(),
                                        "price", productEntity.getvTxt_priceProduct(),
                                        "description", productEntity.getvTxt_descriptionProduct()
                                );
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void deleteData(String name){
        db.collection("products").whereEqualTo("name", name)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<ProductEntity> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                document.getReference().delete();
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
