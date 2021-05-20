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
@Entity(name = "dispositivo")
public class Dispositivos {
    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDispositivo;

    //Columnas de la tabla
    @Column
    private String nombre;
    @Column
    private Boolean activo;
    @Column
    private String ubicacion;
    @Column
    private LocalDate fechaAlta;
    @Column
    private String comentarios;
}
