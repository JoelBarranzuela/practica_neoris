package com.jbarranzuela.prueba.tecnica.users.services;

import com.jbarranzuela.prueba.tecnica.users.dto.request.UserDtoRequest;
import com.jbarranzuela.prueba.tecnica.users.dto.response.UserDtoResponse;
import com.jbarranzuela.prueba.tecnica.users.exception.UsernameFoundException;
import com.jbarranzuela.prueba.tecnica.users.helper.UserHelper;
import com.jbarranzuela.prueba.tecnica.users.model.Users;
import com.jbarranzuela.prueba.tecnica.users.repo.IPhoneRepository;
import com.jbarranzuela.prueba.tecnica.users.repo.UserRepository;
import com.jbarranzuela.prueba.tecnica.users.service.JwtService;
import com.jbarranzuela.prueba.tecnica.users.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;
    @Mock
    private IPhoneRepository phoneRepository;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void successFullyTestWhenUsersIsOk() {

        Users users = UserHelper.createUser();
        UserDtoRequest userDtoRequest = UserHelper.userDtoRequest();
        UserDtoResponse userDtoResponse = UserHelper.userDtoResponse();

        when(jwtService.generateToken(userDtoRequest.getEmail())).thenReturn("TOKEN");
        when(userRepository.save(any())).thenReturn(users);

        assertEquals(userService.createuser(userDtoRequest), userDtoResponse);

    }
}
