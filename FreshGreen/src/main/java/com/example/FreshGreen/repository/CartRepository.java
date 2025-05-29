package com.example.FreshGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FreshGreen.model.FGcart;

public interface CartRepository extends JpaRepository<FGcart, Long> {
    // Additional query methods can be defined here if needed

}
