package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Dispositivos;
import com.sanvalero.nacho.gestionfichajes.exception.DepartamentoNotFoundException;
import com.sanvalero.nacho.gestionfichajes.exception.DispositivosNotFoundException;
import com.sanvalero.nacho.gestionfichajes.repository.DispositivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DispositivosServiceImpl implements DispositivosService {

    @Autowired
    private DispositivosRepository dispositivosRepository;

    @Override
    public Set<Dispositivos> findAll() {
        return dispositivosRepository.findAll();
    }

    @Override
    public Dispositivos addDispositivo(Dispositivos dispositivo) {
        return dispositivosRepository.save(dispositivo);
    }

    @Override
    public Dispositivos modifyDispositivo(long idDispositivo, Dispositivos nuevoDispositivo) {
        Dispositivos dispositivo = dispositivosRepository.findById(idDispositivo)
                .orElseThrow(() -> new DispositivosNotFoundException(idDispositivo));
        nuevoDispositivo.setNombre(dispositivo.getNombre());
        nuevoDispositivo.setActivo(dispositivo.getActivo());
        nuevoDispositivo.setComentarios(dispositivo.getComentarios());
        nuevoDispositivo.setFechaAlta(dispositivo.getFechaAlta());
        nuevoDispositivo.setUbicacion(dispositivo.getUbicacion());
        nuevoDispositivo.setComentarios(dispositivo.getComentarios());
        return dispositivosRepository.save(nuevoDispositivo);
    }

    @Override
    public void deleteDispositivo(long idDispositivo) {
        dispositivosRepository.findById(idDispositivo)
                .orElseThrow(() -> new DepartamentoNotFoundException(idDispositivo));
        dispositivosRepository.deleteById(idDispositivo);

    }
}
