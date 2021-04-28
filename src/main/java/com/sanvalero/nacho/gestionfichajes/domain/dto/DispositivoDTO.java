package com.sanvalero.nacho.gestionfichajes.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class DispositivoDTO {

    private List<String> listaDispositivos;

    private long idDispositivo;
    private String nombre;
    private Boolean activo;
    private String ubicacion;
    private LocalDate fechaAlta;
    private String comentarios;

}
