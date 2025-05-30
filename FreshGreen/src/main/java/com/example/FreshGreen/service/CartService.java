package com.example.FreshGreen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreshGreen.model.FGcart;
import com.example.FreshGreen.model.FGproduct;
import com.example.FreshGreen.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;
    @Autowired
    private com.example.FreshGreen.repository.ProductRepository productRepository;

    //private final List<FGcart> cart = new ArrayList<>();

    public String addToCart(FGproduct product, int quantity) {
        try {
            if (product.getProductStock() < quantity) {
                return "Not enough stock available.";
            }
            // Decrease stock
            product.setProductStock(product.getProductStock() - quantity);
            productRepository.save(product);

            FGcart cartItem = new FGcart(product, product.getProductName(), quantity, product.getProductPrice() * quantity);
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

    public void clearCart() {
        repository.deleteAll();
    }

    // Total item count
    public int getTotalItemCount() {
        return repository.findAll().stream()
                .mapToInt(FGcart::getCount)
                .sum();
    }

    // Grand total price
    public double getGrandTotalPrice() {
        return repository.findAll().stream()
                .mapToDouble(FGcart::getProductPrice)
                .sum();
    }

    // Restock product
    public String restockProduct(Long productId, int amount) {
        Optional<FGproduct> optional = productRepository.findById(productId);
        if (optional.isPresent()) {
            FGproduct product = optional.get();
            product.setProductStock(product.getProductStock() + amount);
            productRepository.save(product);
            return "Product ID " + productId + " restocked by " + amount + " units.";
        } else {
            return "Product not found.";
        }
    }
}
