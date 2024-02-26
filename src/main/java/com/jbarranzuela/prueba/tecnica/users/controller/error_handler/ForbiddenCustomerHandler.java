package com.jbarranzuela.prueba.tecnica.users.controller.error_handler;


import com.jbarranzuela.prueba.tecnica.users.dto.response.BaseErrorResponse;
import com.jbarranzuela.prueba.tecnica.users.dto.response.ErrorResponse;
import com.jbarranzuela.prueba.tecnica.users.exception.ForbiddenCustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenCustomerHandler {

    @ExceptionHandler(ForbiddenCustomerException.class)
    public BaseErrorResponse handleIdNotFound(ForbiddenCustomerException exception) {
        return ErrorResponse.builder()
                .error(exception.getMessage())
                .status(HttpStatus.FORBIDDEN.name())
                .code(HttpStatus.FORBIDDEN.value())
                .build();
    }
}