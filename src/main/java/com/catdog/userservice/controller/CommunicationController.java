package com.catdog.userservice.controller;
import com.catdog.userservice.dto.CommunicationDto;
import com.catdog.userservice.dto.UpdateCommunicationRequest;
import com.catdog.userservice.service.CommunicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/communication")
public class CommunicationController {
    private final CommunicationService communicationService;

    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunicationDto> getCommunicationById(@PathVariable String id){
        return ResponseEntity.ok(communicationService.getCommunicationById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommunicationDto> updateCommunicationById(@Valid @RequestBody UpdateCommunicationRequest request,
                                                                    @PathVariable String id){
        return ResponseEntity.ok(communicationService.updateCommunicationById(request, id));
    }
}
