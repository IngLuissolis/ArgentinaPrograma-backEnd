/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.controller;

import com.proyectointegradorv1.proyectointegradorv1.model.Experiencia;
import com.proyectointegradorv1.proyectointegradorv1.service.ExperienciaServiceImpl;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

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
    @PostMapping(value = "/empleados/experiencias",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Experiencia guardarExperiencia(@RequestPart(value = "logo") MultipartFile file,
            @RequestPart ("empresa") String empresa, @RequestPart ("cargo") String cargo,
            @RequestPart ("fechaIngreso") String fechaIngresoStr, 
            @RequestPart ("fechaEgreso") String fechaEgresoStr,
            @RequestPart ("descripcion0") String descripcion0,
            @RequestPart ("descripcion1") String descripcion1,
            @RequestPart ("descripcion2") String descripcion2
            ) throws IOException, ParseException{
       
        Experiencia experiencia = new Experiencia();
        
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Upload a non-empty file");
	}
	else {
            
            //conversion variable tipo string a Date ya que FormData no acepta variable tipo Date 
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaIngreso = LocalDate.parse(fechaIngresoStr, df);
            LocalDate fechaEgreso = LocalDate.parse(fechaEgresoStr, df);
            
            String originalFilename = file.getOriginalFilename();
            System.out.println("originalFilename = " + originalFilename);
            System.out.println("File Size: " + file.getSize());
            System.out.println("experiencia cargo = " + cargo);
            System.out.println("experiencia fechaIngreso = " + fechaIngreso);
        
            System.out.println("File uploaded successfully");
            
            //guardar experiencia en base de datos
            experiencia.setEmpresa(empresa);
            experiencia.setCargo(cargo);
            experiencia.setFechaIngreso(fechaIngreso);
            experiencia.setFechaEgreso(fechaEgreso);
            experiencia.setDescripcion0(descripcion0);
            experiencia.setDescripcion1(descripcion1);
            experiencia.setDescripcion2(descripcion2);
            experiencia.setLogo(file.getBytes());
	}

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
    public ResponseEntity<Experiencia> actualizarExperienciaPorId(
            @RequestPart(value = "logo") MultipartFile file,
            @RequestPart ("empresa") String empresa, @RequestPart ("cargo") String cargo,
            @RequestPart ("fechaIngreso") String fechaIngresoStr, 
            @RequestPart ("fechaEgreso") String fechaEgresoStr,
            @RequestPart ("descripcion0") String descripcion0,
            @RequestPart ("descripcion1") String descripcion1,
            @RequestPart ("descripcion2") String descripcion2,
            @PathVariable Long id) throws IOException, ParseException{
        
        Experiencia experiencia = new Experiencia();
        
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Upload a non-empty file");
	}
	else {
            
            //conversion variable tipo string a Date ya que FormData no acepta variable tipo Date 
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaIngreso = LocalDate.parse(fechaIngresoStr, df);
            LocalDate fechaEgreso = LocalDate.parse(fechaEgresoStr, df);
        
            System.out.println("experiencia cargada exitosamente!!");
            
            //guardar experiencia editada en base de datos
            experiencia.setId(id);
            experiencia.setEmpresa(empresa);
            experiencia.setCargo(cargo);
            experiencia.setFechaIngreso(fechaIngreso);
            experiencia.setFechaEgreso(fechaEgreso);
            experiencia.setDescripcion0(descripcion0);
            experiencia.setDescripcion1(descripcion1);
            experiencia.setDescripcion2(descripcion2);
            experiencia.setLogo(file.getBytes());
	}
        Experiencia experienciaActualizada = ExperienciaService.actualizarExperienciaPorId(id, experiencia);
        return ResponseEntity.ok(experienciaActualizada);
    }
    
    //metodo eliminar experiencia
    @DeleteMapping("/empleados/experiencias/{id}")
    public void eliminarExperiencia(@PathVariable Long id){
        ExperienciaService.eliminarExperiencia(id);
    }

}
