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
import com.example.FreshGreen.service.LoginService;
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

    @Autowired
    private LoginService loginService;

    @Autowired
    private com.example.FreshGreen.repository.ProductRepository productRepository;

    @PostMapping("/login")
    public String login(@RequestBody FGlogin login) {
        return loginService.validateLogin(login) ? "Login successful" : "Invalid credentials";
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
            FGproduct product = productRepository.findById(productId).orElse(null);
            if (product == null) {
                return "Product not found";
            }
            return cartService.addToCart(product, quantity);
        } catch (Exception e) {
            return "Failed to add to cart: " + e.getMessage();
        }
    }

    @GetMapping("/cart")
    public List<FGcart> viewCart() {
        return cartService.getCartItems();
    }
    @DeleteMapping("/cart")
    public String clearCart(@RequestParam Long cartId) {
        try {
            cartService.clearCart(cartId);
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

