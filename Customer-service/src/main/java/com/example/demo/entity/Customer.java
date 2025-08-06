package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private String customerId;
    private String name;
    private String email;

    // Constructors
    public Customer() {}
    
    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
