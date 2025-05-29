package com.example.FreshGreen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FGcontact {
    
    private String name;
    private String phone;
    @Id
    private String email;
    private String subject;
    private String message;

    public FGcontact() {
    }
    public FGcontact(Long id, String name, String phone, String email, String subject, String message) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
