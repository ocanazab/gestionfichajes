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

import java.util.Optional;
import java.util.Set;

@RestController
public class DepartamentoController {

    private final Logger logger = LoggerFactory.getLogger(DepartamentoController.class);

    @Autowired
    private DepartamentoService departamentoService;


    //Listado de departamentos por nombre
    @GetMapping(value = "/departamentos", produces = "application/json")
    public ResponseEntity<Set<Departamento>> getDepartamento(@RequestParam(value = "nombre", defaultValue = "") String nombredep) {
        logger.info("inicio obtención de departamentos");
        Set<Departamento> departamentos = null;
        if (nombredep.isEmpty())
            departamentos = departamentoService.findAll();
        else
            departamentos = departamentoService.findByName(nombredep);

        logger.info("fin listado departamentos");
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    //Listado de departamentos por id
    @GetMapping(value = "/departamentos/{id}", produces = "application/json")
    public ResponseEntity<Departamento> getDepartamento(@PathVariable long idDepartamento) {
        Departamento departamento = departamentoService.findById(idDepartamento)
                .orElseThrow(() -> new DepartamentoNotFoundException(idDepartamento));

        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    //Añadir un departamento
    @PostMapping(value = "/departamentos", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Departamento> addProduct(@RequestBody Departamento departamento) {
        Departamento departamentoadd = departamentoService.addDepartamento(departamento);
        return new ResponseEntity<>(departamentoadd, HttpStatus.CREATED);
    }

    //Modificar un departamento
    @PutMapping(value = "/departamentos/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Departamento> modifyProduct(@PathVariable long idDepartamento, @RequestBody Departamento nuevoDepartamento) {
        Departamento departamento = departamentoService.modifyDepartamento(idDepartamento,nuevoDepartamento);
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    //Eliminar un departamento
    @DeleteMapping(value = "/departamentos/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteProduct(@PathVariable long idDepartamento) {
        departamentoService.deleteDepartamento(idDepartamento);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @ExceptionHandler(DepartamentoNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(DepartamentoNotFoundException pnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND, pnfe.getMessage());
        logger.error(pnfe.getMessage(), pnfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
