package com.catdog.userservice.service;

import com.catdog.userservice.dto.CreateUserRequest;
import com.catdog.userservice.dto.UpdateUserRequest;
import com.catdog.userservice.dto.UserDto;
import com.catdog.userservice.dto.converter.UserDtoConverter;
import com.catdog.userservice.exception.UserNotFoundException;
import com.catdog.userservice.model.Communication;
import com.catdog.userservice.model.User;
import com.catdog.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final CommunicationService communicationService;

    public UserService(UserRepository userRepository,
                       UserDtoConverter userDtoConverter,
                       CommunicationService communicationService) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.communicationService = communicationService;
    }

    public UserDto createUser(CreateUserRequest createUserRequest){
        Communication communication = communicationService.createUserCommunication(createUserRequest.getEmail());

        User user = new User(createUserRequest.getType(),
                createUserRequest.getName(),
                createUserRequest.getSurname(),
                communication);

        return userDtoConverter.convertToUserDto(userRepository.save(user));
    }

    public Set<UserDto> getAllUser(){

        return userRepository.findAll()
                .stream()
                .map(userDtoConverter::convertToUserDto)
                .collect(Collectors.toSet());
    }

    public UserDto getUserById(String id){
        return userDtoConverter.convertToUserDto(findUserById(id));
    }

    public UserDto updateUser(UpdateUserRequest updateUserRequest, String id){
        User user = findUserById(id);

        User updatedUser = new User(user.getId(),
                updateUserRequest.getType(),
                updateUserRequest.getName(),
                updateUserRequest.getSurname(),
                user.getCommunication(),
                user.getAccount(),
                user.getCreationDate());

        userRepository.save(updatedUser);

        return userDtoConverter.convertToUserDto(updatedUser);
    }

    public String deleteUserById(String id){
        User user = findUserById(id);

        userRepository.delete(user);
        return "The user " + id + " was deleted !!";
    }

    protected User findUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("The user could not be found with the id: " + id)
                );
    }

    protected User updateUser(User user){
        return userRepository.save(user);
    }


    protected void initialUserData(User userRequested, String email){
        Communication communication = communicationService.createUserCommunication(email);

        User user = new User(userRequested.getType(),
                userRequested.getName(),
                userRequested.getSurname(),
                communication);

        userRepository.save(user);

        System.out.println("Initial user data was saved with id: " + user.getId());
    }

    protected void removeAccountById(String accountId) {
        User user = userRepository.findUserByAccountId(accountId)
                .orElseThrow(
                        () -> new UserNotFoundException("The user could not be found with the account id: " + accountId)
                );

        User updatedUser = new User(
                user.getId(),
                user.getType(),
                user.getName(),
                user.getSurname(),
                user.getCommunication(),
                null,
                user.getCreationDate()
        );

        userRepository.save(updatedUser);
    }
}
