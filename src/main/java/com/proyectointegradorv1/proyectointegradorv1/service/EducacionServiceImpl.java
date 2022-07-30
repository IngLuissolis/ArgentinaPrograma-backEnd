/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.exceptions.ResourceNotFoundException;
import com.proyectointegradorv1.proyectointegradorv1.model.Educacion;
import com.proyectointegradorv1.proyectointegradorv1.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionServiceImpl implements EducacionService{
    
    @Autowired
    private EducacionRepository EducacionRepo;

    @Override
    public Educacion obtenerEducacionPorId(Long id) {
        Educacion educacion = EducacionRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe la Formación Academica con id " + id));
        return educacion;
    }

    @Override
    public Educacion actualizarEducacionPorId(Long id, Educacion detallesEducacion) {
        Educacion educacion = EducacionRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe la Formación Academica con id " + id));
        educacion.setInstitucion(detallesEducacion.getInstitucion());
        educacion.setNombreCurso(detallesEducacion.getNombreCurso());
        educacion.setFechaIngresoCurso(detallesEducacion.getFechaIngresoCurso());
        educacion.setFechaEgresoCurso(detallesEducacion.getFechaEgresoCurso());
        educacion.setEducacionDescripcion0(detallesEducacion.getEducacionDescripcion0());
        educacion.setEducacionDescripcion1(detallesEducacion.getEducacionDescripcion1());
        educacion.setEducacionDescripcion2(detallesEducacion.getEducacionDescripcion2());
        educacion.setEducacionLogo(detallesEducacion.getEducacionLogo());
        
        return EducacionRepo.save(educacion);
    }

    @Override
    public List<Educacion> listarTodasLasEducaciones() {
        return EducacionRepo.findAll();
    }

    @Override
    public Educacion guardarEducacion(Educacion educacion) {
        return EducacionRepo.save(educacion);
    }

    @Override
    public void eliminarEducacion(Long id) {
        EducacionRepo.deleteById(id);
    }
    
}
