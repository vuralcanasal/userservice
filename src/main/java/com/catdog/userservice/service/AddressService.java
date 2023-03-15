package com.catdog.userservice.service;

import com.catdog.userservice.dto.AddressDto;
import com.catdog.userservice.dto.CreateAddressRequest;
import com.catdog.userservice.dto.converter.AddressDtoConverter;
import com.catdog.userservice.exception.AddressNotFoundException;
import com.catdog.userservice.model.Address;
import com.catdog.userservice.model.Communication;
import com.catdog.userservice.repository.AddressRepository;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CommunicationService communicationService;
    private final AddressDtoConverter addressDtoConverter;

    public AddressService(AddressRepository addressRepository, CommunicationService communicationService, AddressDtoConverter addressDtoConverter) {
        this.addressRepository = addressRepository;
        this.communicationService = communicationService;
        this.addressDtoConverter = addressDtoConverter;
    }

    public AddressDto createAddress(CreateAddressRequest createAddressDto){
        Communication communication = communicationService.findCommunicationById(createAddressDto.getCommunicationId());

        Address address = new Address(createAddressDto.getLine(),
                createAddressDto.getCity(),
                createAddressDto.getProvince(),
                communication);

        addressRepository.save(address);

        return addressDtoConverter.convertToAddressDto(address);
    }

    public AddressDto getAddressById(String id){
        return addressDtoConverter.convertToAddressDto(findAddressById(id));
    }

    public Set<AddressDto> getAllAddress(){

        return addressRepository.findAll()
                .stream()
                .map(addressDtoConverter::convertToAddressDto)
                .collect(Collectors.toSet());
    }
    public Set<AddressDto> getAllAddressByCommunicationId(String communicationId){
        Communication communication = communicationService.findCommunicationById(communicationId);

        if(communication.getAddresses().isEmpty()){
            return Collections.emptySet();
        }

        return communication.getAddresses()
                .stream()
                .map(addressDtoConverter::convertToAddressDto)
                .collect(Collectors.toSet());
    }

    public String deleteAddressById(String id){
        Address address = findAddressById(id);

        addressRepository.delete(address);

        return "The address " + id + " was deleted !!";
    }

    protected Address findAddressById(String id){
        return addressRepository.findById(id)
                .orElseThrow(
                        () -> new AddressNotFoundException("The address could not be found with the id: " + id)
                );
    }
}
