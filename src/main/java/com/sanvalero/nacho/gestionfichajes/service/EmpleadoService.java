package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Empleado;

import java.util.Optional;
import java.util.Set;

public interface EmpleadoService {
    Set<Empleado> findAll();
    Empleado addEmpleado(Empleado empleado);
    Empleado modifyEmpleado(long idEmpleado, Empleado nuevoEmpleado);
    void deleteEmpleado(long idEmpleado);
}
