package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Departamento;
import com.sanvalero.nacho.gestionfichajes.exception.DepartamentoNotFoundException;
import com.sanvalero.nacho.gestionfichajes.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Set<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento addDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento modifyDepartamento(long id, Departamento nuevoDepartamento) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new DepartamentoNotFoundException(id));
        nuevoDepartamento.setNombre(departamento.getNombre());
        nuevoDepartamento.setActivo(departamento.getActivo());
        nuevoDepartamento.setDescripcion(departamento.getDescripcion());
        nuevoDepartamento.setEmpresa(departamento.getEmpresa());
        nuevoDepartamento.setFechaCreacion(departamento.getFechaCreacion());
        return departamentoRepository.save(nuevoDepartamento);
    }

    @Override
    public void deleteDepartamento(long id) {
        departamentoRepository.findById(id)
                .orElseThrow(() -> new DepartamentoNotFoundException(id));
        departamentoRepository.deleteById(id);
    }
}
