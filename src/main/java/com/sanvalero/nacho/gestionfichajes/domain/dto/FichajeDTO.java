package com.sanvalero.nacho.gestionfichajes.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class FichajeDTO {

    private List<String> listaFichajes;

    private long idFichaje;
    private long idEmpleado;
    private long idDispositivo;
    private long idRegistro;
    private LocalDate fechaCreacion;
    private Boolean borrado;

}
