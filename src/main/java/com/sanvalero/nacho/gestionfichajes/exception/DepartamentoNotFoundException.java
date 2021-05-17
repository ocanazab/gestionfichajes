package com.sanvalero.nacho.gestionfichajes.exception;

public class DepartamentoNotFoundException extends RuntimeException{
    public DepartamentoNotFoundException() { super(); }

    public DepartamentoNotFoundException(String message) {
        super(message);
    }

    public DepartamentoNotFoundException(long id) {
        super("Departamento no encontrado: " + id);
    }
}
