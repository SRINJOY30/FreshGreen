package com.example.FreshGreen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FreshGreen.model.FGcart;
import com.example.FreshGreen.model.FGcontact;
import com.example.FreshGreen.model.FGlogin;
import com.example.FreshGreen.model.FGproduct;
import com.example.FreshGreen.service.CartService;
import com.example.FreshGreen.service.ContactService;
import com.example.FreshGreen.service.ProductService;

@RestController
@RequestMapping("/store")
public class FGcontroller {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ContactService contactService;

    @PostMapping("/login")
    public String login(@RequestBody FGlogin login) {
        try {
            if ("admin".equals(login.getUsername()) && "admin".equals(login.getPassword())) {
                return "Login successful";
            } else {
                return "Invalid credentials";
            }
        } catch (Exception e) {
            return "Login failed: " + e.getMessage();
        }
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody FGproduct product) {
        try {
            productService.saveproduct(product);
            return "Product added successfully";
        } catch (Exception e) {
            return "Failed to add product: " + e.getMessage();
        }
    }
    
    @GetMapping("/products")
    public List<FGproduct> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/cart")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        try {
            FGproduct product = productService.getProductById(productId);
            if (product != null) {
                cartService.addToCart(product, quantity);
                return "Added to cart";
            } else {
                return "Product not found";
            }
        } catch (Exception e) {
            return "Failed to add to cart: " + e.getMessage();
        }
    }

    @GetMapping("/cart")
    public List<FGcart> viewCart() {
        return cartService.getCartItems();
    }

    @DeleteMapping("/cart/{id}")
    public String clearCart(@RequestParam Long id) {
        try {
            cartService.clearCart(id);
            return "Cart cleared successfully";
        } catch (Exception e) {
            return "Failed to clear cart: " + e.getMessage();
        }
    }

    @PostMapping("/contact")
    public String submitContact(@RequestBody FGcontact message) {
        return contactService.saveMessage(message);
    }
    @GetMapping("/contact/messages")
    public List<FGcontact> getAllMessages() {
        return contactService.getAllMessages();
    }
}

