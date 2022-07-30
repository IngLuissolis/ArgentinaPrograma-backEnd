/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.model.Experiencia;
import java.util.List;


public interface ExperienciaService {
    
    public Experiencia obtenerExperienciaPorId(Long id);
    
    public Experiencia actualizarExperienciaPorId(Long id, Experiencia detallesExperiencia);

    public List<Experiencia> listarTodasLasExperiencias();
    
    public Experiencia guardarExperiencia(Experiencia experiencia);
    
    public void eliminarExperiencia(Long id);
    
}
