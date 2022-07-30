/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="empleados")
@Getter @Setter
public class Empleado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombre", nullable=false)
    private String nombre;
    
    @Column(name="apellido", nullable=false)
    private String apellido;
    
    @Column(name="profesion", nullable=false)
    private String profesion;
    
    @Column(name="direccion", nullable=false)
    private String direccion;
    
    @Column(name="celular", nullable=false)
    private String celular;
    
    @Column(name="email", nullable=false, unique=true) //email unico
    private String email;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, String apellido, String profesion, 
            String celular, String direccion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
    }
    
    
}
