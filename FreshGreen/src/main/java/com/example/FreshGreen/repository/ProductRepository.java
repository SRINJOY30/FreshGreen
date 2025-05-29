package com.example.FreshGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FreshGreen.model.FGproduct;

public interface ProductRepository extends JpaRepository<FGproduct, Long> {

}
