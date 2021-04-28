package com.sanvalero.nacho.gestionfichajes.exception;

public class DispositivosNotFoundException extends RuntimeException{
    public DispositivosNotFoundException() { super(); }

    public DispositivosNotFoundException(String message) {
        super(message);
    }

    public DispositivosNotFoundException(long idDispositivo) {
        super("Dispositivo not found: " + idDispositivo);
    }
}
