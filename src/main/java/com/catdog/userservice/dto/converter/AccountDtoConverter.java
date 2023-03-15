package com.catdog.userservice.dto.converter;

import com.catdog.userservice.dto.AccountDto;
import com.catdog.userservice.dto.AccountUserDto;
import com.catdog.userservice.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {

    public AccountDto convertToAccountDto(Account from){
        if(from == null){
            return new AccountDto("","");
        }
        return new AccountDto(from.getId(), from.getIban());
    }

    public AccountUserDto convertToAccountUserDto(Account from,
                                                  String userId,
                                                  String userName,
                                                  String userSurname){
        if(from == null){
            return new AccountUserDto("",
                    "",
                    userId,
                    userName,
                    userSurname);
        }
        return new AccountUserDto(from.getId(),
                from.getIban(),
                userId,
                userName,
                userSurname);
    }
}
