package com.sanvalero.nacho.gestionfichajes.repository;

import com.sanvalero.nacho.gestionfichajes.domain.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
    Set<Departamento> findAll();
    Set<Departamento> findbyName(String nombre);
    Set<Departamento> findbyEmpresa(String empresa);
}
