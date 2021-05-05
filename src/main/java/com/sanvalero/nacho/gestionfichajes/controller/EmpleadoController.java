package com.sanvalero.nacho.gestionfichajes.controller;

import com.sanvalero.nacho.gestionfichajes.domain.Dispositivos;
import com.sanvalero.nacho.gestionfichajes.domain.Empleado;
import com.sanvalero.nacho.gestionfichajes.exception.DispositivosNotFoundException;
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

    //Listado de empleados por nombre
    @GetMapping(value = "/empleados", produces = "application/json")
    public ResponseEntity<Set<Empleado>> getEmpleado(@RequestParam(value = "nombre", defaultValue = "") String nombreemp) {
        logger.info("inicio obtención de empleados");
        Set<Empleado> empleados= null;
        if (nombreemp.isEmpty())
            empleados = empleadoService.findAll();
        else
            empleados = empleadoService.findByNombre(nombreemp);

        logger.info("fin listado empleados");
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    //Listado de empleados por id
    @GetMapping(value = "/empleados/{id}", produces = "application/json")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable long idEmpleado) {
        Empleado empleado = empleadoService.findById(idEmpleado)
                .orElseThrow(() -> new EmpleadoNotFoundException(idEmpleado));

        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    //Listado de empleados por departamento
    @GetMapping(value = "/empleados/{idDepartamento}", produces = "application/json")
    public ResponseEntity<Set<Empleado>> getEmpleadoDep(@RequestParam(value = "idDepartamento", defaultValue = "") String nombredep) {
        logger.info("inicio obtención de empleados por departamento");
        Set<Empleado> empleados= null;
        if (nombredep.isEmpty())
            return new ResponseEntity<>(empleados, HttpStatus.BAD_REQUEST);
        else
            empleados = empleadoService.findByDepartamento(nombredep);

        logger.info("fin listado empleados por departamento");
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

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

    //Eliminar un dispositivo
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
