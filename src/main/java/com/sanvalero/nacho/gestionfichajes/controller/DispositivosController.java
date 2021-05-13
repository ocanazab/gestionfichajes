package com.sanvalero.nacho.gestionfichajes.controller;

import com.sanvalero.nacho.gestionfichajes.domain.Dispositivos;
import com.sanvalero.nacho.gestionfichajes.exception.DispositivosNotFoundException;
import com.sanvalero.nacho.gestionfichajes.service.DispositivosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class DispositivosController {
    private final Logger logger = LoggerFactory.getLogger(DispositivosController.class);

    @Autowired
    private DispositivosService dispositivosService;

    //Listado de dispositivos por nombre
    @GetMapping(value = "/dispositivos", produces = "application/json")
    public ResponseEntity<Set<Dispositivos>> getDispositivo(@RequestParam(value = "nombre", defaultValue = "") String nombredisp) {
        logger.info("inicio obtención de departamentos");
        Set<Dispositivos> dispositivos= null;
        if (nombredisp.isEmpty())
            dispositivos = dispositivosService.findAll();
        else
            dispositivos = dispositivosService.findbyNombre(nombredisp);

        logger.info("fin listado dispositivos");
        return new ResponseEntity<>(dispositivos, HttpStatus.OK);
    }

    //Listado de dispositivos por id
    @GetMapping(value = "/dispositivos/{id}", produces = "application/json")
    public ResponseEntity<Dispositivos> getDispositivoId(@PathVariable long idDispositivo) {
        Dispositivos dispositivos = dispositivosService.findById(idDispositivo)
                .orElseThrow(() -> new DispositivosNotFoundException(idDispositivo));

        return new ResponseEntity<>(dispositivos, HttpStatus.OK);
    }


    @GetMapping(value = "/dispositivos/{ubicacion}", produces = "application/json")
    public ResponseEntity<Set<Dispositivos>> getDispositivoUbic(@RequestParam(value = "ubicacion", defaultValue = "") String ubicacion) {
        Set<Dispositivos> dispositivos= null;
        if (ubicacion.isEmpty())
            return new ResponseEntity<>(dispositivos, HttpStatus.BAD_REQUEST);
        else
            dispositivos = dispositivosService.findbyUbicacion(ubicacion);
            return new ResponseEntity<>(dispositivos, HttpStatus.OK);

    }

    //Añadir un dispositivo
    @PostMapping(value = "/dispositivos", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Dispositivos> addDispositivo(@RequestBody Dispositivos dispositivos) {
        Dispositivos dispositivoadd = dispositivosService.addDispositivo(dispositivos);
        return new ResponseEntity<>(dispositivoadd, HttpStatus.CREATED);
    }

    //Modificar un dispositivo
    @PutMapping(value = "/dispositivos/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Dispositivos> modifyDispositivo(@PathVariable long idDispositivo, @RequestBody Dispositivos nuevoDispositivo) {
        Dispositivos dispositivo = dispositivosService.modifyDispositivo(idDispositivo,nuevoDispositivo);
        return new ResponseEntity<>(dispositivo, HttpStatus.OK);
    }

    //Eliminar un dispositivo
    @DeleteMapping(value = "/dispositivos/{id}", produces = "application/json")
    public ResponseEntity<Response> deleteDispositivo(@PathVariable long idDispositivo) {
        dispositivosService.deleteDispositivo(idDispositivo);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @ExceptionHandler(DispositivosNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleException(DispositivosNotFoundException disnfe) {
        Response response = Response.errorResponse(Response.NOT_FOUND, disnfe.getMessage());
        logger.error(disnfe.getMessage(), disnfe);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
