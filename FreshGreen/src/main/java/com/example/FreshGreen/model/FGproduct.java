package com.example.FreshGreen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FGproduct {
    @Id
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productCategory;
    private int productStock;
    private String productSupplier;

    public FGproduct() {
    }
    public FGproduct(Long productId, String productName, String productDescription, double productPrice, String productCategory, int productStock, String productSupplier) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productStock = productStock;
        this.productSupplier = productSupplier;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public int getProductStock() {
        return productStock;
    }
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    public String getProductSupplier() {
        return productSupplier;
    }
    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }
}
