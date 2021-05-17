package com.sanvalero.nacho.gestionfichajes.exception;

public class RegistrosNotFoundException extends RuntimeException{
    public RegistrosNotFoundException() {
        super();
    }

    public RegistrosNotFoundException(String message) {
        super(message);
    }

    public RegistrosNotFoundException(long id) {
        super("Registro no encontrado: " + id);
    }
}
