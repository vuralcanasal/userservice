package com.catdog.userservice.service;

import com.catdog.userservice.dto.CommunicationDto;
import com.catdog.userservice.dto.UpdateCommunicationRequest;
import com.catdog.userservice.dto.converter.CommunicationDtoConverter;
import com.catdog.userservice.exception.CommunicationNotFoundException;
import com.catdog.userservice.exception.InvalidEmailRequestException;
import com.catdog.userservice.model.Communication;
import com.catdog.userservice.repository.CommunicationRepository;
import org.springframework.stereotype.Service;

@Service
public class CommunicationService {

    private final CommunicationRepository communicationRepository;
    private final CommunicationDtoConverter communicationDtoConverter;

    public CommunicationService(CommunicationRepository communicationRepository,
                                CommunicationDtoConverter communicationDtoConverter) {
        this.communicationRepository = communicationRepository;
        this.communicationDtoConverter = communicationDtoConverter;
    }

    public CommunicationDto getCommunicationById(String id){
        return communicationDtoConverter.convertToCommunicationDto(findCommunicationById(id));
    }

    public CommunicationDto updateCommunicationById(UpdateCommunicationRequest updateCommunicationRequest,
                                                        String id){
        Communication communication = findCommunicationById(id);
        if(communication.getEmail().equals(updateCommunicationRequest.getEmail())){
           Communication updatedCommunication = new Communication(communication.getId(),
                   communication.getEmail(),
                   updateCommunicationRequest.getPhone(),
                   communication.getAddresses(),
                   communication.getCreationDate());

           communicationRepository.save(updatedCommunication);
           return communicationDtoConverter.convertToCommunicationDto(updatedCommunication);
        }

        else{
            if(findCommunicationByEmail(updateCommunicationRequest.getEmail()) != null){
                throw new InvalidEmailRequestException("The email " +
                        updateCommunicationRequest.getEmail() +
                        " is already exist !!");
            }

            Communication updatedCommunication = new Communication(communication.getId(),
                    updateCommunicationRequest.getEmail(),
                    updateCommunicationRequest.getPhone(),
                    communication.getAddresses(),
                    communication.getCreationDate());
            communicationRepository.save(updatedCommunication);
            return communicationDtoConverter.convertToCommunicationDto(updatedCommunication);
        }
    }

    protected Communication createUserCommunication(String email){
        if(findCommunicationByEmail(email) != null){
            throw new InvalidEmailRequestException("The email " +
                    email +
                    " is already exist !!");
        }
        Communication communication = new Communication(email);
        return communicationRepository.save(communication);
    }

    protected Communication findCommunicationById(String id){
        return communicationRepository.findById(id)
                .orElseThrow(
                        () -> new CommunicationNotFoundException("The communication could not be found with the id: " + id)
                );
    }

    protected Communication findCommunicationByEmail(String email){
        return communicationRepository.findCommunicationByEmail(email);
    }

    protected Communication updateCommunication(Communication communication){
        return communicationRepository.save(communication);
    }
}
