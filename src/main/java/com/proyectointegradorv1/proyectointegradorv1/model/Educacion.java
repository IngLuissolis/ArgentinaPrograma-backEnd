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

/**
 *
 * @author eduso
 */
@Entity
@Table(name="educacion")
@Getter @Setter
public class Educacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="institucion", nullable=false)
    private String institucion;
    
    @Column(name="nombreCurso", nullable=false)
    private String nombreCurso;
    
    @Column(name="fechaIngresoCurso", nullable=false)
    private LocalDate fechaIngresoCurso;
    
    @Column(name="fechaEgresoCurso", nullable=false)
    private LocalDate fechaEgresoCurso;
    
    @Column(name="educacionDescripcion0")
    private String educacionDescripcion0;
    
    @Column(name="educacionDescripcion1")
    private String educacionDescripcion1;
    
    @Column(name="educacionDescripcion2")
    private String educacionDescripcion2;
    
     @Column(name="educacionLogo")
    private String educacionLogo;
    
    public Educacion (){
    }
    
    public Educacion (Long id, String institucion, String nombreCurso, LocalDate fechaIngresoCurso,
            LocalDate fechaEgresoCurso, String educacionDescripcion0, String educacionDescripcion1,
            String educacionDescripcion2, String educacionLogo){
        this.id = id;
        this.institucion = institucion;
        this.nombreCurso = nombreCurso;
        this.fechaIngresoCurso = fechaIngresoCurso;
        this.fechaEgresoCurso = fechaEgresoCurso;
        this.educacionDescripcion0 = educacionDescripcion0;
        this.educacionDescripcion1 = educacionDescripcion1;
        this.educacionDescripcion2 = educacionDescripcion2;
        this.educacionLogo = educacionLogo;
    }
    
}
