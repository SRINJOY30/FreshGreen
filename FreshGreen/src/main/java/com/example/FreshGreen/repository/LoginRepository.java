package com.example.FreshGreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FreshGreen.model.FGlogin;

public interface LoginRepository extends JpaRepository<FGlogin, String> {

}
