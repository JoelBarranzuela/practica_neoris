package com.jbarranzuela.prueba.tecnica.users.exception;

public class IdNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Record no exist in %s";

    public IdNotFoundException(String tableName) {
        super(String.format(ERROR_MESSAGE, tableName));
    }

}
