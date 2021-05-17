package com.sanvalero.nacho.gestionfichajes.exception;

public class FichajeNotFoundException extends RuntimeException{
    public FichajeNotFoundException() {
        super();
    }

    public FichajeNotFoundException(String message) {
        super(message);
    }

    public FichajeNotFoundException(long id) {
        super("Fichaje not encontrado: " + id);
    }
}
