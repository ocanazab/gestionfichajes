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
    public Set<Fichaje> findbyEmpleado(int empleado) { return fichajeRepository.findbyEmpleado(empleado); }

    @Override
    public Set<Fichaje> findbyDepartamento(int departamento) { return fichajeRepository.findbyDepartamento(departamento); }

    @Override
    public Set<Fichaje> findbyRegistro(int registro) { return fichajeRepository.findbyRegistro(registro); }

    @Override
    public Set<Fichaje> findbyEmpleadoDepartamento(int empleado, int departamento) { return fichajeRepository.findbyEmpleadoDepartamento(empleado,departamento); }

    @Override
    public Set<Fichaje> findbyEmplDepFecha(int empleado, int departamento, LocalDate fecha) { return fichajeRepository.findbyEmplDepFecha(empleado,departamento,fecha); }

    @Override
    public Fichaje addFichaje(Fichaje fichaje) { return fichajeRepository.save(fichaje); }

    @Override
    public Fichaje modifyFichaje(long idFichaje, Fichaje nuevoFichaje) {

        Fichaje fichaje = fichajeRepository.findById(idFichaje)
                .orElseThrow(() -> new FichajeNotFoundException(idFichaje));
        nuevoFichaje.setIdEmpleado(nuevoFichaje.getIdEmpleado());
        nuevoFichaje.setIdDepartamento(nuevoFichaje.getIdDepartamento());
        nuevoFichaje.setIdDispositivo(nuevoFichaje.getIdDispositivo());
        nuevoFichaje.setIdRegistro(nuevoFichaje.getIdRegistro());
        nuevoFichaje.setFecha(nuevoFichaje.getFecha());
        nuevoFichaje.setBorrado(nuevoFichaje.getBorrado());

        return fichajeRepository.save(nuevoFichaje);
    }

    @Override
    public void deleteFichaje(long idFichaje){
        Fichaje fichaje = fichajeRepository.findById(idFichaje)
                .orElseThrow(() -> new FichajeNotFoundException(idFichaje));

        fichajeRepository.deleteById(idFichaje);
    }


}
