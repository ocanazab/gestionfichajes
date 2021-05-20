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
    public Registros addRegistro(Registros registro) {
        return registrosRepository.save(registro);
    }

    @Override
    public Registros modifyRegistro(long idRegistro, Registros nuevoRegistro) {
        Registros registros = registrosRepository.findById(idRegistro)
                .orElseThrow(() -> new EmpleadoNotFoundException(idRegistro));
        nuevoRegistro.setCodigoRegistro(registros.getCodigoRegistro());
        nuevoRegistro.setDescripcion(registros.getDescripcion());
        nuevoRegistro.setObservaciones(registros.getObservaciones());
        nuevoRegistro.setFechaCreacion(registros.getFechaCreacion());
        nuevoRegistro.setTipoDispositivo(registros.getTipoDispositivo());
        return registrosRepository.save(nuevoRegistro);
    }

    @Override
    public void deleteRegistro(long idRegistro) {
        registrosRepository.findById(idRegistro)
                .orElseThrow(() -> new RegistrosNotFoundException(idRegistro));
        registrosRepository.deleteById(idRegistro);
    }
}
