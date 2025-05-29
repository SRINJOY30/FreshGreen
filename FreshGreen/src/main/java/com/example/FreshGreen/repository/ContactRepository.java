package com.example.FreshGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FreshGreen.model.FGcontact;

public interface ContactRepository extends JpaRepository<FGcontact, String> {
}

