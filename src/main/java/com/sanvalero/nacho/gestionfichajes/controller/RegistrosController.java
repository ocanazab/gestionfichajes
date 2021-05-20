package com.sanvalero.nacho.gestionfichajes.controller;

import com.sanvalero.nacho.gestionfichajes.domain.Registros;
import com.sanvalero.nacho.gestionfichajes.exception.RegistrosNotFoundException;
import com.sanvalero.nacho.gestionfichajes.service.RegistrosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class RegistrosController {
    private final Logger logger = LoggerFactory.getLogger(RegistrosController.class);

    @Autowired
    private RegistrosService registrosService;


    //Añadir un registro
    @PostMapping(value = "/registro", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Registros> addRegistro(@RequestBody Registros registros) {
        Registros registrosadd = registrosService.addRegistro(registros);
        return new ResponseEntity<>(registrosadd, HttpStatus.CREATED);
    }

    //Modificar un registro
    @PutMapping(value = "/registro/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Registros> modifyRegistro(@PathVariable long idRegistro, @RequestBody Registros nuevoRegistro) {
        Registros registros = registrosService.modifyRegistro(idRegistro,nuevoRegistro);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    //Eliminar un registro
    @DeleteMapping(value = "/registro/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteRegistro(@PathVariable long idRegistro) {
        registrosService.deleteRegistro(idRegistro);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @ExceptionHandler(RegistrosNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(RegistrosNotFoundException regnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND, regnfe.getMessage());
        logger.error(regnfe.getMessage(), regnfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
