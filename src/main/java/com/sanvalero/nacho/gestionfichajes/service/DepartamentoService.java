package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Departamento;
import java.util.Optional;
import java.util.Set;

public interface DepartamentoService {
    Set<Departamento> findAll();
    Departamento addDepartamento(Departamento departamento);
    Departamento modifyDepartamento(long id, Departamento nuevoDepartamento);
    void deleteDepartamento(long id);
}

