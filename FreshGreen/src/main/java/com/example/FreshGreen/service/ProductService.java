package com.example.FreshGreen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreshGreen.model.FGproduct;
import com.example.FreshGreen.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    //private final List<FGproduct> products = new ArrayList<>();

    public FGproduct saveproduct(FGproduct product) {
        return repository.save(product);
    }

    public List<FGproduct> getAllProducts() {
        return repository.findAll();
    }

    public FGproduct getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
