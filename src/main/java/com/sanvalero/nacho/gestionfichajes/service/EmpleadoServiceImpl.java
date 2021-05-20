package com.sanvalero.nacho.gestionfichajes.service;

import com.sanvalero.nacho.gestionfichajes.domain.Empleado;
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
    public Empleado addEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado modifyEmpleado(long idEmpleado, Empleado nuevoEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EmpleadoNotFoundException(idEmpleado));
        nuevoEmpleado.setActivo(empleado.getActivo());
        nuevoEmpleado.setNombre(empleado.getNombre());
        nuevoEmpleado.setApellidos(empleado.getApellidos());
        nuevoEmpleado.setTelefono(empleado.getTelefono());
        nuevoEmpleado.setFechaAlta(empleado.getFechaAlta());
        nuevoEmpleado.setActivo(empleado.getActivo());
        nuevoEmpleado.setDepartamento(empleado.getDepartamento());
        return empleadoRepository.save(nuevoEmpleado);
    }

    @Override
    public void deleteEmpleado(long idEmpleado) {
        empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EmpleadoNotFoundException(idEmpleado));
        empleadoRepository.deleteById(idEmpleado);
    }
}
