package com.sanvalero.nacho.gestionfichajes.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class DepartamentoDTO {
    private List<String> departamentos;

    private long idDepartamento;
    private String nombre;
    private String descripcion;
    private Boolean activo;
    private LocalDate fechaCreacion;
    private String empresa;
}
