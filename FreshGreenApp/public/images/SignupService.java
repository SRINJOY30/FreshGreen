package com.example.FreshGreen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreshGreen.model.FGsignup;
import com.example.FreshGreen.repository.SignupRepository;

@Service
public class SignupService {

    @Autowired
    private SignupRepository signupRepository;

    public String register(FGsignup signup) {
        try {
            signupRepository.save(signup);
            return "Signup successful.";
        } catch (Exception e) {
            return "Signup failed: " + e.getMessage();
        }
    }

    public List<FGsignup> getAllSignups() {
        return signupRepository.findAll();
    }

    public Optional<Signup> getByEmail(String email) {
        return signupRepository.findByEmail(email);
    }
}

