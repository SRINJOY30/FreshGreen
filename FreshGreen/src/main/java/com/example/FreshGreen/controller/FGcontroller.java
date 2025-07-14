package com.example.FreshGreen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FreshGreen.model.FGcontact;
import com.example.FreshGreen.model.FGlogin;
import com.example.FreshGreen.model.FGproduct;
import com.example.FreshGreen.model.FGsignup;
import com.example.FreshGreen.service.CartService;
import com.example.FreshGreen.service.ContactService;
import com.example.FreshGreen.service.LoginService;
import com.example.FreshGreen.service.ProductService;
import com.example.FreshGreen.service.SignupService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

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
    private SignupService signupService;

    @Autowired
    private com.example.FreshGreen.repository.ProductRepository productRepository;

    @PostMapping("/signup")
    public String signup(@RequestBody FGsignup signup) {
        return signupService.register(signup);
    }

    @GetMapping("/signup")
    public List<FGsignup> getAllSignups() {
        return signupService.getAllSignups();
    }
    
    @PostMapping("/login")
    public String login(@RequestBody FGlogin login) {
        return loginService.validateLogin(login);
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

    @DeleteMapping("/cart")
    public String clearCart(@RequestParam Long cartId) {
        try {
            cartService.clearCart(cartId);
            return "Cart cleared successfully";
        } catch (Exception e) {
            return "Failed to clear cart: " + e.getMessage();
        }
    }
    @GetMapping("/cart/details")
    public Map<String, Object> getCartDetails() {
        Map<String, Object> details = new HashMap<>();
        details.put("items", cartService.getCartItems());
        details.put("totalItems", cartService.getTotalItemCount());
        details.put("grandTotal", cartService.getGrandTotalPrice());
        return details;
    }

    @PostMapping("/product/restock")
    public String restockProduct(@RequestParam Long productId, @RequestParam int amount) {
        return cartService.restockProduct(productId, amount);
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

