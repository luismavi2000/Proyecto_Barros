package com.example.barrosapi.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(String message) {
        super(message);
    }

    public ClienteNotFoundException(Integer id) {
        super("City not found: " + id);
    }
}
