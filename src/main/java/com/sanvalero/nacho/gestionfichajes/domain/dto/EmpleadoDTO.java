package com.sanvalero.nacho.gestionfichajes.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class EmpleadoDTO {

    private List<String> empleados;
    private long idEmpleado;
    private String nombre;
    private String apellidos;
    private int telefono;
    private boolean activo;
    private LocalDate fechaAlta;
}
