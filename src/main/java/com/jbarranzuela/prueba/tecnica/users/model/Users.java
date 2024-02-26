package com.jbarranzuela.prueba.tecnica.users.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$",
            message = "La contraseña debe contener al menos una letra minúscula, una letra mayúscula, un dígito y un carácter especial, y tener una longitud mínima de 8 caracteres.")
    private String password;

    private LocalDateTime creationUserAt;

    private LocalDateTime modifiedUserAt;

    private LocalDateTime lastLoginAt;

    private String token;

    private boolean isActive;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "users",
            orphanRemoval = true
    )
    private List<Phone> phones;

}
