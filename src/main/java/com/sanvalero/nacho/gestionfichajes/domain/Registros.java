package com.sanvalero.nacho.gestionfichajes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Registros {
    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegistro;

    //Un tipo de registro pertenece a varios fichajes. Pero un fichaje solo puede tener un tipo de registro.
    @OneToMany( targetEntity=Fichaje.class )
    private List listaRegistros;

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

