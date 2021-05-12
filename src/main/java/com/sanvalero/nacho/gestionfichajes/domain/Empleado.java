package com.sanvalero.nacho.gestionfichajes.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "empleado")
public class Empleado {

    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpleado;

    //Un empleado registra un fichaje y un fichaje pertenece a un empleado.
    @OneToMany( targetEntity=Fichaje.class )
    private List listaEmpleados;

    //Columnas de la tabla
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private int telefono;
    @Column
    private Boolean activo;
    @Column
    private LocalDate fechaAlta;
    @Column
    private int idDepartamento;

}
