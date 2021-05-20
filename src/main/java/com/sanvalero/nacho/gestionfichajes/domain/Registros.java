package com.sanvalero.nacho.gestionfichajes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="registros")
public class Registros {
    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegistro;

    //Columnas de la tabla
    @Column
    private int codigoRegistro;
    @Column
    private String descripcion;
    @Column
    private String observaciones;
    @Column
    private LocalDate fechaCreacion;
    @Column
    private String tipoDispositivo;
}

