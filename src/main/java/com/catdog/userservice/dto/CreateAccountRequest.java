package com.catdog.userservice.dto;

import javax.validation.constraints.NotBlank;

public class CreateAccountRequest {
    @NotBlank(message = "The user id cannot be empty")
    private final String userId;
    @NotBlank(message = "The IBAN cannot be empty")
    private final String iban;

    public CreateAccountRequest(String userId, String iban) {
        this.userId = userId;
        this.iban = iban;
    }

    public String getUserId() {
        return userId;
    }

    public String getIban() {
        return iban;
    }
}
