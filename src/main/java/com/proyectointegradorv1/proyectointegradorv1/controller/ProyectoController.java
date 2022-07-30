/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.controller;

import com.proyectointegradorv1.proyectointegradorv1.model.Proyectos;
import com.proyectointegradorv1.proyectointegradorv1.service.ProyectosServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class ProyectoController {
    
    @Autowired
    private ProyectosServiceImpl ProyectosService;
    
    //metodo para listar todas los proyectos 
    @GetMapping("/empleados/proyectos")
    public List<Proyectos> listarTodosLosProyectos(){
        return ProyectosService.listarTodosLosProyectos();
    }
    
    //metodo guardar proyecto
    @PostMapping("/empleados/proyectos")
    public Proyectos guardarProyecto(@RequestBody Proyectos proyecto){
        return ProyectosService.guardarProyectos(proyecto);
    }
    
    //metodo buscar proyecto por id
    @GetMapping("/empleados/proyectos/{id}")
    public ResponseEntity<Proyectos> obtenerProyectoPorId(@PathVariable Long id){
        Proyectos proyecto = ProyectosService.obtenerProyectosPorId(id);
        return ResponseEntity.ok(proyecto);
    }
    
    //metodo editar proyecto por id
    @PutMapping("/empleados/proyectos/{id}")
    public ResponseEntity<Proyectos> actualizarProyectoPorId(@PathVariable Long id, @RequestBody Proyectos detallesProyecto){
        Proyectos proyectoActualizado = ProyectosService.actualizarProyectosPorId(id, detallesProyecto);
        return ResponseEntity.ok(proyectoActualizado);
    }
    
    //metodo eliminar proyecto
    @DeleteMapping("/empleados/proyectos/{id}")
    public void eliminarProyecto(@PathVariable Long id){
        ProyectosService.eliminarProyectos(id);
    }
}
