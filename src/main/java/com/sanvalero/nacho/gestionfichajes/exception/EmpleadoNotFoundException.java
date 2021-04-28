package com.sanvalero.nacho.gestionfichajes.exception;
/**
 * Excepción al no encontrar un empleado
 * @author Nacho Bazán
 */
public class EmpleadoNotFoundException extends RuntimeException {

    public EmpleadoNotFoundException() {
        super();
    }

    public EmpleadoNotFoundException(String message) {
        super(message);
    }

    public EmpleadoNotFoundException(long id) {
        super("Empleado not found: " + id);
    }
}
