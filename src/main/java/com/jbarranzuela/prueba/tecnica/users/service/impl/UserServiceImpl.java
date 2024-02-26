package com.jbarranzuela.prueba.tecnica.users.service.impl;

import com.jbarranzuela.prueba.tecnica.users.dto.request.UserDtoRequest;
import com.jbarranzuela.prueba.tecnica.users.dto.response.UserDtoResponse;
import com.jbarranzuela.prueba.tecnica.users.exception.UsernameFoundException;
import com.jbarranzuela.prueba.tecnica.users.exception.UsernameNotFoundException;
import com.jbarranzuela.prueba.tecnica.users.model.Users;
import com.jbarranzuela.prueba.tecnica.users.repo.IPhoneRepository;
import com.jbarranzuela.prueba.tecnica.users.repo.UserRepository;
import com.jbarranzuela.prueba.tecnica.users.service.IUserService;
import com.jbarranzuela.prueba.tecnica.users.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final IPhoneRepository phoneRepository;

    private final JwtService jwtService;

    @Override
    public List<UserDtoResponse> getAllUsers() {

        List<Users> users = userRepository.findAll();

        List<UserDtoResponse> usersResponse = new ArrayList<>();

        users.forEach(user -> {
            UserDtoResponse userDtoResponse = UserDtoResponse.builder().id(user.getId().toString())
                    .created(user.getCreationUserAt())
                    .token(user.getToken())
                    .isActive(String.valueOf(user.isActive()))
                    .lastLogin(user.getLastLoginAt())
                    .modified(user.getModifiedUserAt())
                    .build();
            usersResponse.add(userDtoResponse);
        });
        return usersResponse;
    }

    @Override
    public UserDtoResponse createuser(UserDtoRequest userDtoRequest) {

        Optional<Users> isRegistered = this.userRepository.findByEmail(userDtoRequest.getEmail());

        if (isRegistered.isPresent()) {
            throw new UsernameFoundException("El usuario con el email: " + userDtoRequest.getEmail() + " ya esta registrado");
        }
        String jwtToken = this.jwtService.generateToken(userDtoRequest.getEmail());
        Users users = Users.builder().name(userDtoRequest.getName()).email(userDtoRequest.getEmail())
                .token(jwtToken)
                .password(userDtoRequest.getPassword()).phones(userDtoRequest.getPhones())
                .creationUserAt(LocalDateTime.now()).isActive(true).lastLoginAt(LocalDateTime.now()).build();
        Users usersSaved = this.userRepository.save(users);
        userDtoRequest.getPhones().forEach(phone -> {
            phone.setUserId(usersSaved.getId());
            this.phoneRepository.save(phone);
        });

        return UserDtoResponse.builder().id(usersSaved.getId().toString()).token(jwtToken)
                .created(usersSaved.getCreationUserAt())
                .isActive(String.valueOf(usersSaved.isActive()))
                .lastLogin(usersSaved.getLastLoginAt())
                .modified(usersSaved.getModifiedUserAt())
                .build();
    }

    @Override
    public UserDtoResponse enabledOrDisabledUser(String email) {
        Users user = this.userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(email));
        user.setActive(!user.isActive());
        user.setModifiedUserAt(LocalDateTime.now());
        Users userSaved = this.userRepository.save(user);

        return UserDtoResponse.builder().id(userSaved.getId().toString())
                .created(userSaved.getCreationUserAt())
                .token(userSaved.getToken())
                .isActive(String.valueOf(userSaved.isActive()))
                .lastLogin(userSaved.getLastLoginAt())
                .modified(userSaved.getModifiedUserAt())
                .build();
    }
}