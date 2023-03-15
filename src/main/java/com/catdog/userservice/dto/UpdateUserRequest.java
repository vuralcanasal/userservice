package com.catdog.userservice.dto;

import com.catdog.userservice.model.UserType;
import javax.validation.constraints.NotBlank;

public class UpdateUserRequest {
    @NotBlank(message = "The user name cannot be empty")
    private final String name;
    @NotBlank(message = "The user surname cannot be empty")
    private final String surname;
    @NotBlank(message = "The user type cannot be empty")
    private final UserType type;

    public UpdateUserRequest(String name, String surname, UserType type) {
        this.name = name;
        this.surname = surname;
        this.type = type;
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
}
