package com.catdog.userservice.dto;

public class AccountDto {
    private final String id;

    private final String iban;

    public AccountDto(String id, String iban) {
        this.id = id;
        this.iban = iban;
    }

    public String getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }
}
