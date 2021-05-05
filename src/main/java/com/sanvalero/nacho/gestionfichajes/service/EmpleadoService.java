package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Empleado;

import java.util.Optional;
import java.util.Set;

public interface EmpleadoService {
    Set<Empleado> findAll();
    Optional<Empleado> findById(long idEmpleado);
    Set<Empleado> findByDepartamento(String departamento);
    Set<Empleado> findByNombre(String nombre);
    Set<Empleado> findByEstado(Boolean estado);
    Empleado addEmpleado(Empleado empleado);
    Empleado modifyEmpleado(long idEmpleado, Empleado nuevoEmpleado);
    void deleteEmpleado(long idEmpleado);
}
