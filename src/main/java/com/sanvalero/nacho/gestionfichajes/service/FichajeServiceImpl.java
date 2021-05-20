package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Fichaje;
import com.sanvalero.nacho.gestionfichajes.exception.FichajeNotFoundException;
import com.sanvalero.nacho.gestionfichajes.repository.FichajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class FichajeServiceImpl implements FichajeService{

    @Autowired
    FichajeRepository fichajeRepository;

    @Override
    public Set<Fichaje> findAll() { return fichajeRepository.findAll(); }

    @Override
    public Fichaje addFichaje(Fichaje fichaje) { return fichajeRepository.save(fichaje); }

    @Override
    public Fichaje modifyFichaje(long idFichaje, Fichaje nuevoFichaje) {

        Fichaje fichaje = fichajeRepository.findById(idFichaje)
                .orElseThrow(() -> new FichajeNotFoundException(idFichaje));
        nuevoFichaje.setIdEmpleado(fichaje.getIdEmpleado());
        nuevoFichaje.setIdDispositivo(fichaje.getIdDispositivo());
        nuevoFichaje.setIdRegistro(fichaje.getIdRegistro());
        nuevoFichaje.setFecha(fichaje.getFecha());
        nuevoFichaje.setBorrado(fichaje.getBorrado());

        return fichajeRepository.save(nuevoFichaje);
    }

    @Override
    public void deleteFichaje(long idFichaje){
        Fichaje fichaje = fichajeRepository.findById(idFichaje)
                .orElseThrow(() -> new FichajeNotFoundException(idFichaje));

        fichajeRepository.deleteById(idFichaje);
    }


}
