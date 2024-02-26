package com.jbarranzuela.prueba.tecnica.users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "phone")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String number;
    private String cityCode;
    private String countryCode;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private UUID userId;
}