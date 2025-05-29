package com.example.FreshGreen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FGlogin {
    
    @Id
    private String username;
    private String password;

    public FGlogin() {
    }
    public FGlogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}