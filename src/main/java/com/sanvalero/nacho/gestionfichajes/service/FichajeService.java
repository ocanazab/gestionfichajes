package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Empleado;
import com.sanvalero.nacho.gestionfichajes.domain.Fichaje;

import java.time.LocalDate;
import java.util.Set;

public interface FichajeService {
    Set<Fichaje> findAll();
    Fichaje addFichaje(Fichaje fichaje);
    Fichaje modifyFichaje(long idFichaje, Fichaje nuevoFichaje);
    void deleteFichaje(long idFichaje);
}
