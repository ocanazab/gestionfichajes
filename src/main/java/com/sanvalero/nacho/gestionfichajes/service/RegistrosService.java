package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Registros;

import java.util.Optional;
import java.util.Set;

public interface RegistrosService {
    Set<Registros> findAll();
    Optional<Registros> findById(long idRegistro);
    Set<Registros> findByCodRegistro(int codRegistro);
    Registros addRegistro(Registros registro);
    Registros modifyRegistro(long idRegistro, Registros nuevoRegistro);
    void deleteRegistro(long idRegistro);
}
