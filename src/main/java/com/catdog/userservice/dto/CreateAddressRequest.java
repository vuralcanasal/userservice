package com.catdog.userservice.dto;

import javax.validation.constraints.NotBlank;

public class CreateAddressRequest {
    @NotBlank(message = "The communication id cannot be empty")
    private final String communicationId;

    private final String line;

    private final String city;
    @NotBlank(message = "The province cannot be empty")
    private final String province;

    public CreateAddressRequest(String communicationId, String line, String city, String province) {
        this.communicationId = communicationId;
        this.line = line;
        this.city = city;
        this.province = province;
    }

    public String getCommunicationId() {
        return communicationId;
    }

    public String getLine() {
        return line;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }
}
