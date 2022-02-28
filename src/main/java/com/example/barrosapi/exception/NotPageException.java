package com.example.barrosapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotPageException extends RuntimeException {
    public NotPageException() {
        super("No se puede acceder a la página que estás solicitando");
    }
}