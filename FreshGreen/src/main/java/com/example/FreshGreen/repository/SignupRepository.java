package com.example.FreshGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FreshGreen.model.FGsignup;

public interface SignupRepository extends JpaRepository<FGsignup, Long> {

}