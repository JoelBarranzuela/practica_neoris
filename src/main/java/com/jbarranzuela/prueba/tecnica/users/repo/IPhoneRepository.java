package com.jbarranzuela.prueba.tecnica.users.repo;

import com.jbarranzuela.prueba.tecnica.users.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPhoneRepository extends JpaRepository<Phone, UUID> {
}
