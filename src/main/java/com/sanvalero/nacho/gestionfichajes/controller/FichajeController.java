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

import java.util.Set;

@RestController
public class FichajeController {

    private final Logger logger = LoggerFactory.getLogger(FichajeController.class);

    @Autowired
    private FichajeService fichajeService;


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
