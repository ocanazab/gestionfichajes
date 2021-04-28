package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Departamento;
import com.sanvalero.nacho.gestionfichajes.domain.dto.DepartamentoDTO;

import java.util.Optional;
import java.util.Set;

public interface DepartamentoService {
    Set<Departamento> findAll();
    Optional<Departamento> findById(long id);
    Set<Departamento> findByName(String name);
    Departamento addDepartamento(Departamento departamento);
    Departamento modifyDepartamento(long id, Departamento nuevoDepartamento);
    void deleteDepartamento(long id);
}

