package com.catdog.userservice.dto.converter;

import com.catdog.userservice.dto.AddressDto;
import com.catdog.userservice.dto.CommunicationDto;
import com.catdog.userservice.dto.CommunicationUserDto;
import com.catdog.userservice.model.Communication;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CommunicationDtoConverter {
    private final AddressDtoConverter addressDtoConverter;

    public CommunicationDtoConverter(AddressDtoConverter addressDtoConverter) {
        this.addressDtoConverter = addressDtoConverter;
    }

    public CommunicationDto convertToCommunicationDto(Communication from){
        if(from == null){
            return new CommunicationDto("","","",null);
        }

        if(from.getAddresses() == null){
            Set<AddressDto> addressDto = new HashSet<>();
            addressDto.add(new AddressDto("","","",""));

            return new CommunicationDto(from.getId(),
                    from.getEmail(),
                    from.getPhone(),
                    addressDto);
        }

        return new CommunicationDto(from.getId(),
                from.getEmail(),
                from.getPhone(),
                from.getAddresses()
                        .stream()
                        .map(addressDtoConverter::convertToAddressDto)
                        .collect(Collectors.toSet()));
    }

    public CommunicationUserDto convertToCommunicationUserDto(Communication from,
                                                              String userId,
                                                              String userName,
                                                              String userSurname){
        if(from == null){
            return new CommunicationUserDto("",
                    "",
                    "",
                    null,
                    userId,
                    userName,
                    userSurname);
        }
        return new CommunicationUserDto(from.getId(),
                from.getEmail(),
                from.getPhone(),
                from.getAddresses()
                        .stream()
                        .map(addressDtoConverter::convertToAddressDto)
                        .collect(Collectors.toSet()),
                userId,
                userName,
                userSurname);
    }
}
