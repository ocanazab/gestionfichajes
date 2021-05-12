package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Empleado;
import com.sanvalero.nacho.gestionfichajes.domain.Fichaje;

import java.time.LocalDate;
import java.util.Set;

public interface FichajeService {
    Set<Fichaje> findAll();
    Set<Fichaje> findbyEmpleado(int empleado);
    Set<Fichaje> findbyDepartamento(int departamento);
    Set<Fichaje> findbyRegistro(int registro);
    Set<Fichaje> findbyEmpleadoDepartamento(int empleado, int departamento);
    Set<Fichaje> findbyEmplDepFecha(int empleado, int departamento, LocalDate fecha);
    Fichaje addFichaje(Fichaje fichaje);
    Fichaje modifyFichaje(long idFichaje, Fichaje nuevoFichaje);
    void deleteFichaje(long idFichaje);
}
