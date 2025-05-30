package com.example.FreshGreen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreshGreen.model.FGcart;
import com.example.FreshGreen.model.FGproduct;
import com.example.FreshGreen.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    //private final List<FGcart> cart = new ArrayList<>();

    public String addToCart(FGproduct product, int quantity) {
        try {
            FGcart cartItem = new FGcart(product,product.getProductName() , quantity, product.getProductPrice() * quantity);
            repository.save(cartItem);
            return "Item added to cart successfully.";
        } catch (Exception e) {
            return "Error adding to cart: " + e.getMessage();
        }
    }

    public List<FGcart> getCartItems() {
        return repository.findAll();
    }

    public void clearCart(Long cartId) {
        repository.deleteById(cartId);
    }

    public void updateCartItem(Long cartId, int newQuantity) {
        FGcart cartItem = repository.findById(cartId).orElse(null);
        if (cartItem != null) {
            cartItem.setCount(newQuantity);
            cartItem.setProductPrice(cartItem.getProduct().getProductPrice() * newQuantity);
            repository.save(cartItem);
        }
        else {
            throw new RuntimeException("Cart item not found with ID: " + cartId);
        }
    }

    public void clearCart() {
        repository.deleteAll();
    }
}
