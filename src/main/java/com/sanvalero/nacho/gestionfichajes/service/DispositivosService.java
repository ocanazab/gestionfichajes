package com.sanvalero.nacho.gestionfichajes.service;


import com.sanvalero.nacho.gestionfichajes.domain.Departamento;
import com.sanvalero.nacho.gestionfichajes.domain.Dispositivos;

import java.util.Optional;
import java.util.Set;

public interface DispositivosService {
    Set<Dispositivos> findAll();
    Optional<Dispositivos> findById(long idDispositivo);
    Set<Dispositivos> findbyNombre(String nombre);
    Set<Dispositivos> findbyUbicacion(String ubicacion);
    Dispositivos addDispositivo(Dispositivos dispositivo);
    Dispositivos modifyDispositivo(long idDispositivo, Dispositivos nuevoDispositivo);
    void deleteDispositivo(long idDispositivo);
}
