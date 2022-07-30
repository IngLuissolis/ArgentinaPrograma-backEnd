/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.model.Proyectos;
import java.util.List;

/**
 *
 * @author eduso
 */
public interface ProyectosService {
    
    public Proyectos obtenerProyectosPorId(Long id);
    
    public Proyectos actualizarProyectosPorId(Long id, Proyectos detallesProyectos);

    public List<Proyectos> listarTodosLosProyectos();
    
    public Proyectos guardarProyectos(Proyectos proyecto);
    
    public void eliminarProyectos(Long id);
    
}
