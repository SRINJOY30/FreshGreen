package com.example.FreshGreen.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class FGsignup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private FGlogin login;

    public FGsignup() {
    }
    public FGsignup(String name, String phone, FGlogin login) {
        this.name = name;
        this.phone = phone;
        this.login = login;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public FGlogin getLogin() {
        return login;
    }
    public void setLogin(FGlogin login) {
        this.login = login;
    }
    

}
