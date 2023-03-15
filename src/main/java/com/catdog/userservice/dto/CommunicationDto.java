package com.catdog.userservice.dto;

import java.util.Set;

public class CommunicationDto {
    private final String id;
    private final String email;
    private final String phone;
    private final Set<AddressDto> addresses;

    public CommunicationDto(String id, String email, String phone, Set<AddressDto> addresses) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.addresses = addresses;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Set<AddressDto> getAddresses() {
        return addresses;
    }
}
