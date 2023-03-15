package com.catdog.userservice.dto.converter;

import com.catdog.userservice.dto.AddressDto;
import com.catdog.userservice.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConverter {

    public AddressDto convertToAddressDto(Address from){
        if(from == null){
            return new AddressDto("","","","");
        }

        return new AddressDto(from.getId(),
                from.getLine(),
                from.getCity(),
                from.getProvince());
    }
}
