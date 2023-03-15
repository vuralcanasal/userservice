package com.catdog.userservice.dto;

import java.util.Set;

public class CommunicationUserDto {
    private final String id;
    private final String email;
    private final String phone;
    private final Set<AddressDto> addresses;
    private final String userId;
    private final String userName;
    private final String userSurname;

    public CommunicationUserDto(String id,
                                String email,
                                String phone,
                                Set<AddressDto> addresses,
                                String userId,
                                String userName,
                                String userSurname) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.addresses = addresses;
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
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

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }
}
