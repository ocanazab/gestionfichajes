package com.sanvalero.nacho.gestionfichajes.repository;

import com.sanvalero.nacho.gestionfichajes.domain.Fichaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FichajeRepository extends CrudRepository<Fichaje,Long> {
    Set<Fichaje> findAll();
    Set<Fichaje> findbyEmpleado(int empleado);
    Set<Fichaje> findbyDepartamento(int departamento);
    Set<Fichaje> findbyRegistro(int registro);
    Set<Fichaje> findbyEmpleadoDepartamento(int empleado, int departamento);
}
