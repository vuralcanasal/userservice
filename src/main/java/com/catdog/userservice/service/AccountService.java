package com.catdog.userservice.service;

import com.catdog.userservice.dto.AccountDto;
import com.catdog.userservice.dto.AccountUserDto;
import com.catdog.userservice.dto.CreateAccountRequest;
import com.catdog.userservice.dto.converter.AccountDtoConverter;
import com.catdog.userservice.exception.AccountNotFoundException;
import com.catdog.userservice.model.Account;
import com.catdog.userservice.model.User;
import org.springframework.stereotype.Service;
import com.catdog.userservice.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountDtoConverter accountDtoConverter;
    private final UserService userService;

    public AccountService(AccountRepository accountRepository,
                          AccountDtoConverter accountDtoConverter,
                          UserService userService) {
        this.accountRepository = accountRepository;
        this.accountDtoConverter = accountDtoConverter;
        this.userService = userService;
    }

    public AccountUserDto createAccount(CreateAccountRequest createAccountRequest){
        User userCheck = userService.findUserById(createAccountRequest.getUserId());

        Account account = new Account(createAccountRequest.getIban());

        accountRepository.save(account);

        User updatedUser = userService.updateUser(
                new User(userCheck.getId(),
                userCheck.getType(),
                userCheck.getName(),
                userCheck.getSurname(),
                userCheck.getCommunication(),
                account,
                userCheck.getCreationDate())
        );

        return accountDtoConverter.convertToAccountUserDto(account,
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getSurname());
    }

    public AccountDto getAccountById(String id){
        Account account = findAccountById(id);

        return accountDtoConverter.convertToAccountDto(account);
    }

    public String deleteAccountById(String id){

        userService.removeAccountById(id);
        accountRepository.deleteById(id);
        return "The account " + id + " was deleted !!";
    }

    protected Account findAccountById(String id){
        return accountRepository.findById(id)
                .orElseThrow(
                        () -> new AccountNotFoundException("The account could not be found with the id: " + id)
                );
    }
}
