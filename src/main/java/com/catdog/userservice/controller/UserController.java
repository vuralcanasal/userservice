package com.catdog.userservice.controller;

import com.catdog.userservice.dto.CreateUserRequest;
import com.catdog.userservice.dto.UpdateUserRequest;
import com.catdog.userservice.dto.UserDto;
import com.catdog.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<Set<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUserById(@Valid @RequestBody UpdateUserRequest request, @PathVariable String id){
        return ResponseEntity.ok(userService.updateUser(request, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
