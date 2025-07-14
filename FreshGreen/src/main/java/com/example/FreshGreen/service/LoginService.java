package com.example.FreshGreen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreshGreen.model.FGlogin;
import com.example.FreshGreen.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    public String validateLogin(FGlogin login) {
        try {
            FGlogin existingUser = loginRepository.findByEmail(login.getEmail());
            if (existingUser != null && existingUser.getPassword().equals(login.getPassword())) {
                return "Login successful!";
            } else {
                return "Invalid email or password.";
            }
        } catch (Exception e) {
            return "Error during login: " + e.getMessage();
        }
    }
}
