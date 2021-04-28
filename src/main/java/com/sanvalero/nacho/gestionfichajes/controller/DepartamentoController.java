package com.sanvalero.nacho.gestionfichajes.controller;


import com.sanvalero.nacho.gestionfichajes.domain.Departamento;
import com.sanvalero.nacho.gestionfichajes.service.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class DepartamentoController {

    private final Logger logger = LoggerFactory.getLogger(DepartamentoController.class);

    @Autowired
    private DepartamentoService departamentoService;

    @Operation(summary = "Obtiene el listado de departamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de departamentos",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Departamento.class)))),
    })
    @GetMapping(value = "/departamentos", produces = "application/json")
    public ResponseEntity<Set<Departamento>> getDepartamento(@RequestParam(value = "idDepartamento", defaultValue = "") long id) {
        logger.info("inicio getDepartamento");
        Set<Departamento> departamentos = null;
        if (id==0)
            departamentos = departamentoService.findAll();
        else
            departamentos = departamentoService.findById(id);

        logger.info("fin getProducts");
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

}
