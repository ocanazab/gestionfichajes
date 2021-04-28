package com.sanvalero.nacho.gestionfichajes.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class RegistrosDTO {

    private List<String> listaRegistros;

    private long idRegistro;
    private int codigoRegistro;
    private String descripcion;
    private String observaciones;
    private LocalDate fechaCreacion;
    private String tipoDispositivo;

}
