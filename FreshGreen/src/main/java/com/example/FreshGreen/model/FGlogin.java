package com.example.FreshGreen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FGlogin {
    
    @Id
    private String email;
    private String password;

    public FGlogin() {
    }
    public FGlogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}