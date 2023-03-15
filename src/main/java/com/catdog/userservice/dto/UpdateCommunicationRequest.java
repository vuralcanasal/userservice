package com.catdog.userservice.dto;

import javax.validation.constraints.NotBlank;

public class UpdateCommunicationRequest {
    private final String phone;
    @NotBlank(message = "The email address cannot be empty")
    private final String email;

    public UpdateCommunicationRequest(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
