package com.catdog.userservice.service;

import com.catdog.userservice.model.User;
import com.catdog.userservice.model.UserType;
import org.springframework.stereotype.Service;

@Service
public class InitialData {
    private final UserService userService;

    public InitialData(UserService userService) {
        this.userService = userService;
    }

    public void createInitialData(){
        User user1 = new User(UserType.EMPLOYEER,
                "Employee1",
                "Employee1_Surname");
        userService.initialUserData(user1, "employee1@gmail.com");

        User user2 = new User(UserType.CUSTOMER,
                "customer",
                "customerSurname");
        userService.initialUserData(user2, "customer@yahoo.com");

        System.out.println("The inital data was saved !!");
    }
}
