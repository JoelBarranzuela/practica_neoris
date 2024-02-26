package com.jbarranzuela.prueba.tecnica.users.exception;

public class UsernameFoundException extends RuntimeException {


    private static final String ERROR_MESSAGE = "User exist with email: %s";

    public UsernameFoundException(String email) {
        super(String.format(ERROR_MESSAGE, email));
    }
}
