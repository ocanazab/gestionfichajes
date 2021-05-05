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
    public Optional<Empleado> findById(long idEmpleado) {
        return empleadoRepository.findById(idEmpleado);
    }

    @Override
    public Set<Empleado> findByDepartamento(String departamento) {return empleadoRepository.findByDepartamento(departamento); }

    @Override
    public Set<Empleado> findByNombre(String nombre) {return empleadoRepository.findByNombre(nombre);}

    @Override
    public Set<Empleado> findByEstado(Boolean estado) {return empleadoRepository.findByEstado(estado);}

    @Override
    public Empleado addEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado modifyEmpleado(long idEmpleado, Empleado nuevoEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EmpleadoNotFoundException(idEmpleado));
        nuevoEmpleado.setIdDepartamento(nuevoEmpleado.getIdDepartamento());
        nuevoEmpleado.setActivo(nuevoEmpleado.getActivo());
        nuevoEmpleado.setNombre(nuevoEmpleado.getNombre());
        nuevoEmpleado.setApellidos(nuevoEmpleado.getApellidos());
        nuevoEmpleado.setTelefono(nuevoEmpleado.getTelefono());
        nuevoEmpleado.setFechaAlta(nuevoEmpleado.getFechaAlta());
        nuevoEmpleado.setIdDepartamento(nuevoEmpleado.getIdDepartamento());
        nuevoEmpleado.setActivo(nuevoEmpleado.getActivo());
        return empleadoRepository.save(nuevoEmpleado);
    }

    @Override
    public void deleteEmpleado(long idEmpleado) {
        empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EmpleadoNotFoundException(idEmpleado));
        empleadoRepository.deleteById(idEmpleado);
    }
}
