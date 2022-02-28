package com.example.barrosapi.exception;

public class EventoNotFoundException extends RuntimeException {

    public EventoNotFoundException(String message) {
        super(message);
    }

    public EventoNotFoundException(Integer id) {
        super("City not found: " + id);
    }
}
