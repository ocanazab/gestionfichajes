package com.sanvalero.nacho.gestionfichajes.repository;

import com.sanvalero.nacho.gestionfichajes.domain.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{
    Set<Empleado> findAll();
    Set<Empleado> findByDepartamento(String departamento);
    Set<Empleado> findByNombre(String nombre);
    Set<Empleado> findByEstado(Boolean estado);
}
