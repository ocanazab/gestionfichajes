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


    //Listado de registros por código de registro
    @GetMapping(value = "/registros", produces = "application/json")
    public ResponseEntity<Set<Registros>> getRegistroCod(@RequestParam(value = "codigoRegistro", defaultValue = "") int codigoRegistro) {
        logger.info("inicio obtención de registros");
        Set<Registros> registros= null;
        if (codigoRegistro>0)
            registros = registrosService.findByCodRegistro(codigoRegistro);
        else
            registros=registrosService.findAll();


        logger.info("fin listado registros por codigo de registro");
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    //Listado de registros por id
    @GetMapping(value = "/registros/{id}", produces = "application/json")
    public ResponseEntity<Registros> getRegistros(@PathVariable long idRegistro) {
        Registros registros = registrosService.findById(idRegistro)
                .orElseThrow(() -> new RegistrosNotFoundException(idRegistro));

        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

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
