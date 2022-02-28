package com.example.barrosapi.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String message) {
        super(message);
    }
    public UsuarioNotFoundException(Integer id) {
        super("Usuario not found: " + id);
    }

}
