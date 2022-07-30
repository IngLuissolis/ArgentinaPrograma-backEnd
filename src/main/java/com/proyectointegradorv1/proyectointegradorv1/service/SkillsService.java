/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.model.Skills;
import java.util.List;

public interface SkillsService {
    
    public Skills obtenerSkillsPorId(Long id);
    
    public Skills actualizarSkillsPorId(Long id, Skills detallesSkill);

    public List<Skills> listarTodasLasSkills();
    
    public Skills guardarSkills(Skills skill);
    
    public void eliminarSkills(Long id);
    
}
