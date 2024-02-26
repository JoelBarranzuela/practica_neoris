package com.jbarranzuela.prueba.tecnica.users.controller;

import com.jbarranzuela.prueba.tecnica.users.dto.request.UserDtoRequest;
import com.jbarranzuela.prueba.tecnica.users.dto.response.UserDtoResponse;
import com.jbarranzuela.prueba.tecnica.users.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/user")
@RestController
@AllArgsConstructor
@Tag(name = "User")
public class UserController {

    private final IUserService userService;

    @Operation(summary = "Create user")
    @PostMapping
    public ResponseEntity<UserDtoResponse> createUser(@Valid @RequestBody UserDtoRequest userDtoRequest) {
        return new ResponseEntity<UserDtoResponse>(this.userService.createuser(userDtoRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Enabled or disable user")
    @PatchMapping
    public ResponseEntity<UserDtoResponse> enabledOrDisabledUser(@RequestParam String email) {
        return new ResponseEntity<>(this.userService.enabledOrDisabledUser(email), HttpStatus.OK);
    }

    @Operation(summary = "List users")
    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }
}
