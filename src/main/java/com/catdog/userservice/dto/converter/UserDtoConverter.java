package com.catdog.userservice.dto.converter;

import com.catdog.userservice.dto.UserDto;
import com.catdog.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    private final CommunicationDtoConverter communicationDtoConverter;
    private final AccountDtoConverter accountDtoConverter;

    public UserDtoConverter(CommunicationDtoConverter communicationDtoConverter, AccountDtoConverter accountDtoConverter) {
        this.communicationDtoConverter = communicationDtoConverter;
        this.accountDtoConverter = accountDtoConverter;
    }

    public UserDto convertToUserDto(User from){
        if(from == null){
            return new UserDto("","","",null, null,null);
        }

        return new UserDto(from.getId(),
                from.getName(),
                from.getSurname(),
                from.getType(),
                communicationDtoConverter.convertToCommunicationDto(from.getCommunication()),
                accountDtoConverter.convertToAccountDto(from.getAccount()));
    }
}
