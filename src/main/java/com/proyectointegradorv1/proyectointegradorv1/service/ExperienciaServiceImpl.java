/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.exceptions.ResourceNotFoundException;
import com.proyectointegradorv1.proyectointegradorv1.model.Experiencia;
import com.proyectointegradorv1.proyectointegradorv1.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaServiceImpl implements ExperienciaService{

    @Autowired
    private ExperienciaRepository ExperienciaRepo;

    @Override
    public Experiencia obtenerExperienciaPorId(Long id) {
        Experiencia experiencia = ExperienciaRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe la experiencia con id " + id));
        return experiencia;
        }

    @Override
    public Experiencia actualizarExperienciaPorId(Long id, Experiencia detallesExperiencia) {
        Experiencia experiencia = ExperienciaRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe la experiencia con id " + id));
        experiencia.setEmpresa(detallesExperiencia.getEmpresa());
        experiencia.setFechaIngreso(detallesExperiencia.getFechaIngreso());
        experiencia.setFechaEgreso(detallesExperiencia.getFechaEgreso());
        experiencia.setCargo(detallesExperiencia.getCargo());
        experiencia.setDescripcion0(detallesExperiencia.getDescripcion0());
        experiencia.setDescripcion1(detallesExperiencia.getDescripcion1());
        experiencia.setDescripcion2(detallesExperiencia.getDescripcion2());
        experiencia.setLogo(detallesExperiencia.getLogo());
        
        return ExperienciaRepo.save(experiencia);
        }

    @Override
    public List<Experiencia> listarTodasLasExperiencias() {
        return ExperienciaRepo.findAll();
        }

    @Override
    public Experiencia guardarExperiencia(Experiencia experiencia) {
        return ExperienciaRepo.save(experiencia);
        }

    @Override
    public void eliminarExperiencia(Long id) {
        ExperienciaRepo.deleteById(id);
        }
    
}
