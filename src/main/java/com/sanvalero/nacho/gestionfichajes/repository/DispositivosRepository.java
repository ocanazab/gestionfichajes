package com.sanvalero.nacho.gestionfichajes.repository;

import com.sanvalero.nacho.gestionfichajes.domain.Dispositivos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface DispositivosRepository extends CrudRepository<Dispositivos, Long> {
    Set<Dispositivos> findAll();
    Set<Dispositivos> findbyUbicacion(String ubicacion);
    Set<Dispositivos> findbyNombre(String nombre);
}
