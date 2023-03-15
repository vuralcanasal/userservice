package com.catdog.userservice.controller;

import com.catdog.userservice.dto.AccountDto;
import com.catdog.userservice.dto.AccountUserDto;
import com.catdog.userservice.dto.CreateAccountRequest;
import com.catdog.userservice.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountUserDto> createAccount(@Valid @RequestBody CreateAccountRequest request){
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable String id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable String id){
        return ResponseEntity.ok(accountService.deleteAccountById(id));
    }
}
