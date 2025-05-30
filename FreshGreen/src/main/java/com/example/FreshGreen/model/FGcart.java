package com.example.FreshGreen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FGcart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String productName;
    private int count;
    private double productPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")  // FK column
    private FGproduct product;

    public FGcart() {
    }
    public FGcart(FGproduct product, String productName, int count, double productPrice) {
        this.product = product;
        this.productName = productName;
        this.count = count;
        this.productPrice = productPrice;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public FGproduct getProduct() {
        return product;
    }
    public void setProduct(FGproduct product) {
        this.product = product;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    

}
