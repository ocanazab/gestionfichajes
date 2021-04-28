package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Registros;
import com.sanvalero.nacho.gestionfichajes.exception.EmpleadoNotFoundException;
import com.sanvalero.nacho.gestionfichajes.exception.RegistrosNotFoundException;
import com.sanvalero.nacho.gestionfichajes.repository.RegistrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RegistrosServiceImpl implements RegistrosService{

    @Autowired
    RegistrosRepository registrosRepository;

    @Override
    public Set<Registros> findAll() {
        return registrosRepository.findAll();
    }

    @Override
    public Optional<Registros> findById(long idRegistro) {
        return registrosRepository.findById(idRegistro);
    }

    @Override
    public Registros addRegistro(Registros registro) {
        return registrosRepository.save(registro);
    }

    @Override
    public Registros modifyRegistro(long idRegistro, Registros nuevoRegistro) {
        Registros registros = registrosRepository.findById(idRegistro)
                .orElseThrow(() -> new EmpleadoNotFoundException(idRegistro));
        nuevoRegistro.setDescripcion(nuevoRegistro.getDescripcion());
        nuevoRegistro.setCodigoRegistro(nuevoRegistro.getCodigoRegistro());
        nuevoRegistro.setFechaCreacion(nuevoRegistro.getFechaCreacion());
        nuevoRegistro.setObservaciones(nuevoRegistro.getObservaciones());
        nuevoRegistro.setObservaciones(nuevoRegistro.getObservaciones());
        return registrosRepository.save(nuevoRegistro);
    }

    @Override
    public void deleteRegistro(long idRegistro) {
        registrosRepository.findById(idRegistro)
                .orElseThrow(() -> new RegistrosNotFoundException(idRegistro));
        registrosRepository.deleteById(idRegistro);
    }
}
