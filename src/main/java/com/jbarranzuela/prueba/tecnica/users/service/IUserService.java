package com.jbarranzuela.prueba.tecnica.users.service;

import com.jbarranzuela.prueba.tecnica.users.dto.request.UserDtoRequest;
import com.jbarranzuela.prueba.tecnica.users.dto.response.UserDtoResponse;
import com.jbarranzuela.prueba.tecnica.users.model.Users;

import java.util.List;

public interface IUserService {

    List<UserDtoResponse> getAllUsers();

    UserDtoResponse createuser(UserDtoRequest userDtoRequest);

    UserDtoResponse enabledOrDisabledUser(String email);


}
