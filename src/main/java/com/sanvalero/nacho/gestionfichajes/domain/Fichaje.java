package com.sanvalero.nacho.gestionfichajes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity(name="fichaje")
public class Fichaje {

    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFichaje;

    //Columnas de la tabla
    @Column
    private int idEmpleado;
    @Column
    private int idDepartamento;
    @Column
    private int idDispositivo;
    @Column
    private int idRegistro;
    @Column
    private LocalDate fecha;
    @Column
    private Boolean borrado;

}
