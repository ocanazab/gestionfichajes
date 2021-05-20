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

    @ManyToOne
    @JoinColumn(
            name = "departamento",
            referencedColumnName = "idDepartamento"
    )
    private Departamento departamento;

}
