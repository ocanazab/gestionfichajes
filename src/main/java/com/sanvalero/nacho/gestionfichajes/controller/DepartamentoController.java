package com.sanvalero.nacho.gestionfichajes.controller;


import com.sanvalero.nacho.gestionfichajes.domain.Departamento;
import com.sanvalero.nacho.gestionfichajes.exception.DepartamentoNotFoundException;
import com.sanvalero.nacho.gestionfichajes.service.DepartamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class DepartamentoController {

    private final Logger logger = LoggerFactory.getLogger(DepartamentoController.class);

    @Autowired
    private DepartamentoService departamentoService;


    //Añadir un departamento
    @PostMapping(value = "/departamentos", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Departamento> addDepartamento(@RequestBody Departamento departamento) {
        Departamento departamentoadd = departamentoService.addDepartamento(departamento);
        return new ResponseEntity<>(departamentoadd, HttpStatus.CREATED);
    }

    //Modificar un departamento
    @PutMapping(value = "/departamentos/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Departamento> modifyDepartamento(@PathVariable long idDepartamento, @RequestBody Departamento nuevoDepartamento) {
        Departamento departamento = departamentoService.modifyDepartamento(idDepartamento,nuevoDepartamento);
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    //Eliminar un departamento
    @DeleteMapping(value = "/departamentos/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteDepartamento(@PathVariable long idDepartamento) {
        departamentoService.deleteDepartamento(idDepartamento);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @ExceptionHandler(DepartamentoNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(DepartamentoNotFoundException dnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND, dnfe.getMessage());
        logger.error(dnfe.getMessage(), dnfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
