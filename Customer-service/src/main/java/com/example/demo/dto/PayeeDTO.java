package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayeeDTO {

    private Long id;
    private String payeeName;

    @JsonProperty("payee_account_number")
    private String payeeAccountNumber;

    private String ifscCode;
    private String nickname;
    private String customerId;

    // Getters & Setters
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
}
