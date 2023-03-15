package com.catdog.userservice.dto;

import com.catdog.userservice.model.UserType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateUserRequest {
    @NotBlank(message = "The user name cannot be empty")
    private final String name;
    @NotBlank(message = "The user surname cannot be empty")
    private final String surname;
    @NotNull(message = "The user type cannot be empty")
    private final UserType type;
    @NotBlank(message = "The user email address cannot be empty")
    private final String email;

    public CreateUserRequest(String name, String surname, UserType type, String email) {
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.email = email;
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

    public String getEmail() {
        return email;
    }
}
