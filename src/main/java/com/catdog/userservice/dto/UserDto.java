package com.catdog.userservice.dto;

import com.catdog.userservice.model.UserType;

public class UserDto {
    private final String id;
    private final String name;
    private final String surname;
    private final UserType type;
    private final CommunicationDto communication;
    private final AccountDto account;

    public UserDto(String id, String name, String surname, UserType type, CommunicationDto userCommunicationDto, AccountDto userAccountDto) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.communication = userCommunicationDto;
        this.account = userAccountDto;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UserType getType() {
        return type;
    }

    public CommunicationDto getCommunication() {
        return communication;
    }

    public AccountDto getAccount() {
        return account;
    }
}
