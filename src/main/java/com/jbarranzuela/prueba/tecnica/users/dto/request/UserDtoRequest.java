package com.jbarranzuela.prueba.tecnica.users.dto.request;

import com.jbarranzuela.prueba.tecnica.users.model.Phone;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDtoRequest {

    private String name;
    @Email
    private String email;

    private String password;
    private List<Phone> phones;
}
