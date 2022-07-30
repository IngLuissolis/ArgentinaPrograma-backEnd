/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.controller;

import com.proyectointegradorv1.proyectointegradorv1.model.Experiencia;
import com.proyectointegradorv1.proyectointegradorv1.service.ExperienciaServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//API Rest
@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaController {
    
    @Autowired
    private ExperienciaServiceImpl ExperienciaService;
    
    //metodo para listar todas las experiencias   
    @GetMapping("/empleados/experiencias")
    public List<Experiencia> listarTodasLasExperiencias(){
        return ExperienciaService.listarTodasLasExperiencias();
    }
    
    //metodo guardar experiencia
    @PostMapping("/empleados/experiencias")
    public Experiencia guardarExperiencia(@RequestBody Experiencia experiencia){
        return ExperienciaService.guardarExperiencia(experiencia);
    }
    
    //metodo buscar experiencia por id
    @GetMapping("/empleados/experiencias/{id}")
    public ResponseEntity<Experiencia> obtenerExperienciaPorId(@PathVariable Long id){
        Experiencia experiencia = ExperienciaService.obtenerExperienciaPorId(id);
        return ResponseEntity.ok(experiencia);
    }
    
    //metodo editar experiencia por id
    @PutMapping("/empleados/experiencias/{id}")
    public ResponseEntity<Experiencia> actualizarExperienciaPorId(@PathVariable Long id, @RequestBody Experiencia detallesExperiencia){
        Experiencia experienciaActualizada = ExperienciaService.actualizarExperienciaPorId(id, detallesExperiencia);
        return ResponseEntity.ok(experienciaActualizada);
    }
    
    //metodo eliminar experiencia
    @DeleteMapping("/empleados/experiencias/{id}")
    public void eliminarExperiencia(@PathVariable Long id){
        ExperienciaService.eliminarExperiencia(id);
    }
    
}
