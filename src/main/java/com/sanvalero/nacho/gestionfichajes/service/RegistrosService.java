package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Registros;

import java.util.Optional;
import java.util.Set;

public interface RegistrosService {
    Set<Registros> findAll();
    Registros addRegistro(Registros registro);
    Registros modifyRegistro(long idRegistro, Registros nuevoRegistro);
    void deleteRegistro(long idRegistro);
}
