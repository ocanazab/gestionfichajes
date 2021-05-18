package com.sanvalero.nacho.gestionfichajes.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name="registros")
public class Registros {
    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegistro;

    //Un tipo de registro pertenece a varios fichajes. Pero un fichaje solo puede tener un tipo de registro.
    @OneToMany( targetEntity=Fichaje.class )
    @JoinColumn(name="idRegistro")

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

