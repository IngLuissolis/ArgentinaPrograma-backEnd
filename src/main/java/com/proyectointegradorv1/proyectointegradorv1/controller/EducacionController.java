/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.controller;

import com.proyectointegradorv1.proyectointegradorv1.model.Educacion;
import com.proyectointegradorv1.proyectointegradorv1.service.EducacionServiceImpl;
import java.io.IOException;
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


@RestController
@RequestMapping("/api/v1")
public class EducacionController {
    
    @Autowired
    private EducacionServiceImpl EducacionService;
    
    //metodo para listar todas los educaciones
    @GetMapping("/empleados/educaciones")
    public List<Educacion> listarTodasLasEducaciones(){
        return EducacionService.listarTodasLasEducaciones();
    }
    
    //metodo guardar educacion
    @PostMapping("/empleados/educaciones")
    public Educacion guardarEducacion(@RequestBody Educacion educacion) throws IOException{
        
        return EducacionService.guardarEducacion(educacion);
    }
    
    //metodo buscar educacion por id
    @GetMapping("/empleados/educaciones/{id}")
    public ResponseEntity<Educacion> obtenerEducacionPorId(@PathVariable Long id){
        Educacion educacion = EducacionService.obtenerEducacionPorId(id);
        return ResponseEntity.ok(educacion);
    }
    
    //metodo editar educacion por id
    @PutMapping("/empleados/educaciones/{id}")
    public ResponseEntity<Educacion> actualizarEducacionPorId(@PathVariable Long id, @RequestBody Educacion detallesEducacion){
        Educacion educacionActualizado = EducacionService.actualizarEducacionPorId(id, detallesEducacion);
        return ResponseEntity.ok(educacionActualizado);
    }
    
    //metodo eliminar educacion
    @DeleteMapping("/empleados/educaciones/{id}")
    public void eliminarEducacion(@PathVariable Long id){
        EducacionService.eliminarEducacion(id);
    }
}
