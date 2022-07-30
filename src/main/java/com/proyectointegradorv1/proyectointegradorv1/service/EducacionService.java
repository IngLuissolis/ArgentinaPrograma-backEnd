/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.model.Educacion;
import java.util.List;

/**
 *
 * @author eduso
 */
public interface EducacionService {
    
    
    
    public Educacion obtenerEducacionPorId(Long id);
    
    public Educacion actualizarEducacionPorId(Long id, Educacion detallesEducacion);

    public List<Educacion> listarTodasLasEducaciones();
    
    public Educacion guardarEducacion(Educacion educacion);
    
    public void eliminarEducacion(Long id);
    
}
