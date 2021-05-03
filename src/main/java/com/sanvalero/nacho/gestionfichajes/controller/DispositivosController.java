package com.sanvalero.nacho.gestionfichajes.controller;

import com.sanvalero.nacho.gestionfichajes.domain.Departamento;
import com.sanvalero.nacho.gestionfichajes.domain.Dispositivos;
import com.sanvalero.nacho.gestionfichajes.exception.DepartamentoNotFoundException;
import com.sanvalero.nacho.gestionfichajes.exception.DispositivosNotFoundException;
import com.sanvalero.nacho.gestionfichajes.service.DepartamentoService;
import com.sanvalero.nacho.gestionfichajes.service.DispositivosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Dispositivos> getDispositivo(@PathVariable long idDispositivo) {
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

}
