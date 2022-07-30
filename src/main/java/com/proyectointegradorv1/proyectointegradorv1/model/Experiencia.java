/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="experiencia")
@Getter @Setter
public class Experiencia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="empresa", nullable=false)
    private String empresa;
    
    @Column(name="fechaIngreso", nullable=false)
    private LocalDate fechaIngreso;
    
    @Column(name="fechaEgreso")
    private LocalDate fechaEgreso;
    
    @Column(name="Cargo", nullable=false)
    private String cargo;
    
    @Column(name="descripcion0", nullable=false)
    private String descripcion0;
    
    @Column(name="descripcion1")
    private String descripcion1;
    
    @Column(name="descripcion2")
    private String descripcion2;
    
    @Column(name="logo")
    private String logo;

    public Experiencia() {
    }

    public Experiencia(Long id, String empresa, LocalDate fechaIngreso, 
            LocalDate fechaEgreso,String cargo, String descripcion0, 
            String descripcion1, String descripcion2, String logo) {
        this.id = id;
        this.empresa = empresa;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.cargo = cargo;
        this.descripcion0= descripcion0;
        this.descripcion1= descripcion1;
        this.descripcion2= descripcion2;
        this.logo = logo;
    }
    
    
    
}
