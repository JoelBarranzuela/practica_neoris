package com.jbarranzuela.prueba.tecnica.users.helper;

import com.jbarranzuela.prueba.tecnica.users.dto.request.UserDtoRequest;
import com.jbarranzuela.prueba.tecnica.users.dto.response.UserDtoResponse;
import com.jbarranzuela.prueba.tecnica.users.model.Phone;
import com.jbarranzuela.prueba.tecnica.users.model.Users;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserHelper {

    private static final UUID uuid = new UUID(1,8);


    public static Users createUser() {
        return Users.builder().id(uuid).creationUserAt(null).modifiedUserAt(null)
                .email("joejoel0512@gmail.com").token("TOKEN").name("joel").isActive(true).lastLoginAt(null)
                .password("aA$11111").phones(listPhone(uuid)).build();
    }

    public static Phone createPhone(UUID uuid) {
        return Phone.builder().id(UUID.randomUUID()).userId(uuid).cityCode("15081").countryCode("51").
                number("977822090").build();
    }


    public static Phone createPhoneRequest() {
        return Phone.builder().cityCode("15081").countryCode("51").
                number("977822090").build();
    }

    public static List<Phone> requestListPhone() {
        return List.of(createPhoneRequest());
    }


    public static List<Phone> listPhone(UUID uuid) {
        return List.of(createPhone(uuid));
    }

    public static UserDtoResponse userDtoResponse() {
        return UserDtoResponse.builder().token(createUser().getToken()).id(createUser().getId().toString())
                .created(createUser().getCreationUserAt()).isActive(String.valueOf(createUser().isActive())).
                modified(createUser().getModifiedUserAt()).lastLogin(createUser().getLastLoginAt()).build();
    }

    public static UserDtoResponse userDtoDisabled() {
        return UserDtoResponse.builder().token(createUser().getToken()).id(createUser().getId().toString())
                .created(createUser().getCreationUserAt()).isActive(String.valueOf(!createUser().isActive())).
                modified(createUser().getModifiedUserAt()).lastLogin(createUser().getLastLoginAt()).build();
    }


    public static UserDtoRequest userDtoRequest() {
        return UserDtoRequest.builder()
                .email("joejoel0512@gmail.com").name("joel")
                .password("aA$11111").phones(requestListPhone()).build();
    }
}
