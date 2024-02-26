package com.jbarranzuela.prueba.tecnica.users.exception;

public class ForbiddenCustomerException extends RuntimeException {

    public ForbiddenCustomerException() {
        super("This customer is blocked");
    }
}