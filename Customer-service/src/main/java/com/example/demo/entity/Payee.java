package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "payees")
public class Payee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String payeeName;

    @JsonProperty("payee_account_number")
    @Column(name = "payee_account_number", nullable = false)
    private String payeeAccountNumber;

    private String ifscCode;

    private String nickname;

    @Column(name = "customer_id")
    private String customerId;

    // Optional: the account number field, if different from payeeAccountNumber
    @Transient  // if not stored in DB
    private String accountNumber;

    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPayeeName() {
        return payeeName;
    }
    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeAccountNumber() {
        return payeeAccountNumber;
    }
    public void setPayeeAccountNumber(String payeeAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
