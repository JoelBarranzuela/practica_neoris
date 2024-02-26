package com.jbarranzuela.prueba.tecnica.users.exception;

public class UsernameNotFoundException extends RuntimeException {


    private static final String ERROR_MESSAGE = "User no exist with %s";

    public UsernameNotFoundException(String email) {
        super(String.format(ERROR_MESSAGE, email));
    }
}
