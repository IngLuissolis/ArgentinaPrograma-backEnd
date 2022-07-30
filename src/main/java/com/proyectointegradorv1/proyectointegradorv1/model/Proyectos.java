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
@Table(name="proyectos")
@Getter @Setter
public class Proyectos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombreProyecto", nullable=false)
    private String nombreProyecto;
    
    @Column(name="fechaProyecto", nullable=false)
    private LocalDate fechaProyecto;
    
    @Column(name="proyectoDescripcion0", nullable=false)
    private String proyectoDescripcion0;
    
    @Column(name="proyectoDescripcion1")
    private String proyectoDescripcion1;
    
    @Column(name="url")
    private String url;
    
    @Column(name="proyectoLogo")
    private String proyectoLogo;
    
    public Proyectos(){
    }
    
    public Proyectos(Long id, String nombreProyecto, String url, 
            LocalDate fechaProyecto, String proyectoLogo, String proyectoDescripcion0,
            String proyectoDescripcion1){
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.url = url;
        this.fechaProyecto = fechaProyecto;
        this.proyectoLogo = proyectoLogo;
        this.proyectoDescripcion0 = proyectoDescripcion0;
        this.proyectoDescripcion1 = proyectoDescripcion1;
    }
}
