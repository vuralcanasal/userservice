package com.catdog.userservice.dto;

public class AccountUserDto {
    private final String id;

    private final String iban;

    private final String userId;

    private final String userName;

    private final String userSurname;

    public AccountUserDto(String id, String iban, String userId, String userName, String userSurname) {
        this.id = id;
        this.iban = iban;
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
    }

    public String getId() {
        return id;
    }

    public String getIban() {
        return iban;
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
