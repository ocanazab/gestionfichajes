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
@Entity(name = "departamento")
public class Departamento {

    //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDepartamento;

    //Un departamento puede tener varios empleados, pero un empleado solo pertenece a un departamento.
    @OneToMany( targetEntity=Empleado.class )
    @JoinColumn(name="idDepartamento")


    //Columnas de la tabla
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private Boolean activo;
    @Column
    private LocalDate fechaCreacion;
    @Column
    private String empresa;



}
