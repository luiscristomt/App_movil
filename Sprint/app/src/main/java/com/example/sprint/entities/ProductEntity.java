package com.example.sprint.entities;

public class ProductEntity {

    private int img_product, vTxt_priceProduct;
    private String vTxt_nameProduct, vTxt_descriptionProduct;

    public ProductEntity(int img_product, int vTxt_priceProduct, String vTxt_nameProduct, String vTxt_descriptionProduct) {
        this.img_product = img_product;
        this.vTxt_priceProduct = vTxt_priceProduct;
        this.vTxt_nameProduct = vTxt_nameProduct;
        this.vTxt_descriptionProduct = vTxt_descriptionProduct;
    }

    public int getImg_product() {
        return img_product;
    }

    public void setImg_product(int img_product) {
        this.img_product = img_product;
    }

    public int getvTxt_priceProduct() {
        return vTxt_priceProduct;
    }

    public void setvTxt_priceProduct(int vTxt_priceProduct) {
        this.vTxt_priceProduct = vTxt_priceProduct;
    }

    public String getvTxt_nameProduct() {
        return vTxt_nameProduct;
    }

    public void setvTxt_nameProduct(String vTxt_nameProduct) {
        this.vTxt_nameProduct = vTxt_nameProduct;
    }

    public String getvTxt_descriptionProduct() {
        return vTxt_descriptionProduct;
    }

    public void setvTxt_descriptionProduct(String vTxt_descriptionProduct) {
        this.vTxt_descriptionProduct = vTxt_descriptionProduct;
    }
}
