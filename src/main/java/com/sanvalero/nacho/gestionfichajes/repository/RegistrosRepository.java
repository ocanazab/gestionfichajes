package com.sanvalero.nacho.gestionfichajes.repository;

import com.sanvalero.nacho.gestionfichajes.domain.Registros;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RegistrosRepository extends CrudRepository<Registros, Long> {
    Set<Registros> findAll();
}
