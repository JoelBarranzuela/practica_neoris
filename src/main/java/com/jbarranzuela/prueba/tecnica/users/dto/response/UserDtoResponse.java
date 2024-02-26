package com.jbarranzuela.prueba.tecnica.users.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDtoResponse {

    private String id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private String isActive;

}
