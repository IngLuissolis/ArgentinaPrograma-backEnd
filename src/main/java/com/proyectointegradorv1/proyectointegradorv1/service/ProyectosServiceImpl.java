/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.exceptions.ResourceNotFoundException;
import com.proyectointegradorv1.proyectointegradorv1.model.Proyectos;
import com.proyectointegradorv1.proyectointegradorv1.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosServiceImpl implements ProyectosService{
    
    @Autowired
    private ProyectosRepository ProyectosRepo;

    @Override
    public Proyectos obtenerProyectosPorId(Long id) {
        Proyectos proyecto = ProyectosRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe el Proyecto con id " + id));
        return proyecto;
    }

    @Override
    public Proyectos actualizarProyectosPorId(Long id, Proyectos detallesProyecto) {
        Proyectos proyecto = ProyectosRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe el Proyecto con id " + id));
        proyecto.setNombreProyecto(detallesProyecto.getNombreProyecto());
        proyecto.setUrl(detallesProyecto.getUrl());
        proyecto.setFechaProyecto(detallesProyecto.getFechaProyecto());
        proyecto.setProyectoDescripcion0(detallesProyecto.getProyectoDescripcion0());
        proyecto.setProyectoDescripcion1(detallesProyecto.getProyectoDescripcion1());
        proyecto.setProyectoLogo(detallesProyecto.getProyectoLogo());
        
        return ProyectosRepo.save(proyecto);
    }

    @Override
    public List<Proyectos> listarTodosLosProyectos() {
        return ProyectosRepo.findAll();
    }

    @Override
    public Proyectos guardarProyectos(Proyectos proyecto) {
        return ProyectosRepo.save(proyecto);
    }

    @Override
    public void eliminarProyectos(Long id) {
        ProyectosRepo.deleteById(id);
    }
    
}
