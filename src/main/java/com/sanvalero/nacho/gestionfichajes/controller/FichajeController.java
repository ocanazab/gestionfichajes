package com.sanvalero.nacho.gestionfichajes.controller;

import com.sanvalero.nacho.gestionfichajes.domain.Fichaje;
import com.sanvalero.nacho.gestionfichajes.exception.FichajeNotFoundException;
import com.sanvalero.nacho.gestionfichajes.service.FichajeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
public class FichajeController {

    private final Logger logger = LoggerFactory.getLogger(FichajeController.class);

    @Autowired
    private FichajeService fichajeService;

    //Listado de fichajes por departamento
    @GetMapping(value = "/fichaje/{idDepartamento}", produces = "application/json")
    public ResponseEntity<Set<Fichaje>> getFichajeDep(@RequestParam(value = "idDepartamento", defaultValue = "") Integer departamento) {
        logger.info("inicio obtención de fichajes por departamento");
        Set<Fichaje> fichaje= null;
        if (departamento==null)
            return new ResponseEntity<>(fichaje, HttpStatus.BAD_REQUEST);
        else
            fichaje=fichajeService.findbyDepartamento(departamento);

        logger.info("fin listado fichaje por departamento");
        return new ResponseEntity<>(fichaje, HttpStatus.OK);
    }

    //Listado de fichajes por empleado
    @GetMapping(value = "/fichaje/{idEmpleado}", produces = "application/json")
    public ResponseEntity<Set<Fichaje>> getFichajeEmp(@RequestParam(value = "idEmpleado", defaultValue = "") Integer empleado) {
        logger.info("inicio obtención de fichajes por departamento");
        Set<Fichaje> fichaje= null;
        if (empleado==null)
            return new ResponseEntity<>(fichaje, HttpStatus.BAD_REQUEST);
        else
            fichaje=fichajeService.findbyEmpleado(empleado);

        logger.info("fin listado fichaje por empleado");
        return new ResponseEntity<>(fichaje, HttpStatus.OK);
    }

    //Listado de fichajes por registro
    @GetMapping(value = "/fichaje/{idEmpleado}", produces = "application/json")
    public ResponseEntity<Set<Fichaje>> getFichajeReg(@RequestParam(value = "idRegistro", defaultValue = "") Integer registro) {
        logger.info("inicio obtención de fichajes por departamento");
        Set<Fichaje> fichaje= null;
        if (registro==null)
            return new ResponseEntity<>(fichaje, HttpStatus.BAD_REQUEST);
        else
            fichaje=fichajeService.findbyRegistro(registro);

        logger.info("fin listado fichaje por registro");
        return new ResponseEntity<>(fichaje, HttpStatus.OK);
    }

    //Listado de fichajes por empleado y departamento
    @GetMapping(value = "/fichaje/{idEmpleado}/{idDepartamento}", produces = "application/json")
    public ResponseEntity<Set<Fichaje>> getFichajeEmpDep(@RequestParam(value = "idRegistro", defaultValue = "") Integer empleado, @RequestParam(value="idDepartamento",defaultValue="") Integer departamento) {
        logger.info("inicio obtención de fichajes por empleado y departamento");
        Set<Fichaje> fichaje= null;
        if (empleado==null || departamento==null)
            return new ResponseEntity<>(fichaje, HttpStatus.BAD_REQUEST);
        else
            fichaje=fichajeService.findbyEmpleadoDepartamento(empleado,departamento);
        logger.info("fin listado fichaje por empleado y departamento");
        return new ResponseEntity<>(fichaje, HttpStatus.OK);
    }

    //Listado de fichajes por empleado,departamento y fecha
    @GetMapping(value = "/fichaje/{idEmpleado}/{idDepartamento}/{fecha}", produces = "application/json")
    public ResponseEntity<Set<Fichaje>> getFichajeEmpDepFecha(@RequestParam(value = "idRegistro", defaultValue = "") Integer empleado, @RequestParam(value="idDepartamento",defaultValue="") Integer departamento, @RequestParam(value="fecha",defaultValue="") LocalDate fecha) {
        logger.info("inicio obtención de fichajes por empleado, departamento y fecha");
        Set<Fichaje> fichaje= null;
        if (empleado==null || departamento==null || fecha==null)
            return new ResponseEntity<>(fichaje, HttpStatus.BAD_REQUEST);
        else
            fichaje=fichajeService.findbyEmplDepFecha(empleado,departamento,fecha);
        logger.info("fin listado fichaje por empleado, departamento y fecha");
        return new ResponseEntity<>(fichaje, HttpStatus.OK);
    }


    //Añadir un fichaje
    @PostMapping(value = "/fichaje", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Fichaje> addFichaje(@RequestBody Fichaje fichaje) {
        Fichaje Fichajeadd = fichajeService.addFichaje(fichaje);
        return new ResponseEntity<>(Fichajeadd, HttpStatus.CREATED);
    }

    //Modificar un fichaje
    @PutMapping(value = "/fichaje/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Fichaje> modifyFichaje(@PathVariable long idFichaje, @RequestBody Fichaje nuevoFichaje) {
        Fichaje fichaje = fichajeService.modifyFichaje(idFichaje,nuevoFichaje);
        return new ResponseEntity<>(fichaje, HttpStatus.OK);
    }

    //Eliminar un fichaje
    @DeleteMapping(value = "/fichaje/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteFichaje(@PathVariable long idFichaje) {
        fichajeService.deleteFichaje(idFichaje);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @ExceptionHandler(FichajeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(FichajeNotFoundException finfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND, finfe.getMessage());
        logger.error(finfe.getMessage(), finfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }



}
