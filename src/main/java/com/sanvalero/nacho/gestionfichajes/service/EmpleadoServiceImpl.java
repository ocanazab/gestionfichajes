package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Empleado;
import com.sanvalero.nacho.gestionfichajes.exception.DepartamentoNotFoundException;
import com.sanvalero.nacho.gestionfichajes.exception.EmpleadoNotFoundException;
import com.sanvalero.nacho.gestionfichajes.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Set<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> findById(long idEmpleado) {
        return empleadoRepository.findById(idEmpleado);
    }

    @Override
    public Empleado addEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado modifyEmpleado(long idEmpleado, Empleado nuevoEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EmpleadoNotFoundException(idEmpleado));
        nuevoEmpleado.setIdEmpleado(nuevoEmpleado.getIdEmpleado());
        return empleadoRepository.save(nuevoEmpleado);
    }

    @Override
    public void deleteEmpleado(long idEmpleado) {
        empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new DepartamentoNotFoundException(idEmpleado));
        empleadoRepository.deleteById(idEmpleado);
    }
}
