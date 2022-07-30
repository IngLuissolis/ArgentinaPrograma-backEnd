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
@Table(name="skills")
@Getter @Setter
public class Skills implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombreSkill", nullable=false)
    private String nombreSkill;
    
    @Column(name="valorSkill", nullable=false)
    private Long valorSkill;
    
    @Column(name="skillLogo")
    private String skillLogo;
    
    public Skills(){
    }
    
    public Skills(Long id, String nombreSkill, Long valorSkill, String skillLogo){
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.valorSkill = valorSkill;
        this.skillLogo = skillLogo;
    }
}
