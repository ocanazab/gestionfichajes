package com.sanvalero.nacho.gestionfichajes.controller;

import com.sanvalero.nacho.gestionfichajes.domain.Empleado;
import com.sanvalero.nacho.gestionfichajes.exception.EmpleadoNotFoundException;
import com.sanvalero.nacho.gestionfichajes.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class EmpleadoController {

    private final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private EmpleadoService empleadoService;

    //Añadir un empleado
    @PostMapping(value = "/empleado", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Empleado> addEmpleado(@RequestBody Empleado empleado) {
        Empleado empleadoadd = empleadoService.addEmpleado(empleado);
        return new ResponseEntity<>(empleadoadd, HttpStatus.CREATED);
    }

    //Modificar un empleado
    @PutMapping(value = "/empleado/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Empleado> modifyEmpleado(@PathVariable long idEmpleado, @RequestBody Empleado nuevoEmpleado) {
        Empleado empleado = empleadoService.modifyEmpleado(idEmpleado,nuevoEmpleado);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    //Eliminar un empleado
    @DeleteMapping(value = "/empleado/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteEmpleado(@PathVariable long idEmpleado) {
        empleadoService.deleteEmpleado(idEmpleado);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @ExceptionHandler(EmpleadoNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(EmpleadoNotFoundException emnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND, emnfe.getMessage());
        logger.error(emnfe.getMessage(), emnfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
