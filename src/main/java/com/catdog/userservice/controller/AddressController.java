package com.catdog.userservice.controller;

import com.catdog.userservice.dto.AddressDto;
import com.catdog.userservice.dto.CreateAddressRequest;
import com.catdog.userservice.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/v1/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@Valid @RequestBody CreateAddressRequest request){
        return ResponseEntity.ok(addressService.createAddress(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable String id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @GetMapping("/communication/{communicationId}")
    public ResponseEntity<Set<AddressDto>> getAllAddressByCommunicationId(@PathVariable String communicationId){
        return ResponseEntity.ok(addressService.getAllAddressByCommunicationId(communicationId));
    }

    @GetMapping
    public ResponseEntity<Set<AddressDto>> getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable String id){
        return ResponseEntity.ok(addressService.deleteAddressById(id));
    }
}
