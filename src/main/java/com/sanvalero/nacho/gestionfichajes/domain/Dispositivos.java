package com.sanvalero.nacho.gestionfichajes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "dispositivo")
public class Dispositivos {
    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDispositivo;

    //Un dispositivo pertenece a varios fichajes. Pero un fichaje solo puede pertenecer a un dispositivo.
    @OneToMany( targetEntity=Fichaje.class )
    private List listaDispositivos;

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
