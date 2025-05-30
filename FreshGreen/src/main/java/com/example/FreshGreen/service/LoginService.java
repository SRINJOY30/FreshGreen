package com.example.FreshGreen.service;

import org.springframework.stereotype.Service;

import com.example.FreshGreen.model.FGlogin;

@Service
public class LoginService {

    public boolean validateLogin(FGlogin login) {
        try {
            // Placeholder validation (can be replaced with DB lookup)
            return "admin".equals(login.getUsername()) && "admin".equals(login.getPassword());
        } catch (Exception e) {
            System.out.println("Login validation failed: " + e.getMessage());
            return false;
        }
    }
}
