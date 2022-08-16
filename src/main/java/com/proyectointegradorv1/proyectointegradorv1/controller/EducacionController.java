/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.controller;

import com.proyectointegradorv1.proyectointegradorv1.model.Educacion;
import com.proyectointegradorv1.proyectointegradorv1.service.EducacionServiceImpl;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;


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
    //public Educacion guardarEducacion(@RequestBody Educacion educacion) throws IOException{
    public Educacion guardarEducacion(
        @RequestPart(value = "educacionLogo") MultipartFile file,
            @RequestPart ("institucion") String institucion, 
            @RequestPart ("nombreCurso") String nombreCurso,
            @RequestPart ("fechaIngresoCursoStr") String fechaIngresoCursoStr, 
            @RequestPart ("fechaEgresoCursoStr") String fechaEgresoCursoStr,
            @RequestPart ("educacionDescripcion0") String educacionDescripcion0,
            @RequestPart ("educacionDescripcion1") String educacionDescripcion1,
            @RequestPart ("educacionDescripcion2") String educacionDescripcion2)
            throws IOException, ParseException{
        
        Educacion educacion = new Educacion ();
        
        if(file.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Upload a non-empty file");
        } else {
            //conversion variable tipo string a Date ya que FormData no acepta variable tipo Date 
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaIngresoCurso = LocalDate.parse(fechaIngresoCursoStr, df);
            LocalDate fechaEgresoCurso = LocalDate.parse(fechaEgresoCursoStr, df);
            
            System.out.println("educacion cargada exitosamente!!");
            
            //guardar educacion en base de datos
            educacion.setInstitucion(institucion);
            educacion.setNombreCurso(nombreCurso);
            educacion.setFechaIngresoCurso(fechaIngresoCurso);
            educacion.setFechaEgresoCurso(fechaEgresoCurso);
            educacion.setEducacionDescripcion0(educacionDescripcion0);
            educacion.setEducacionDescripcion1(educacionDescripcion1);
            educacion.setEducacionDescripcion2(educacionDescripcion2);
            educacion.setEducacionLogo(file.getBytes());
        }
        
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
    public ResponseEntity<Educacion> actualizarEducacionPorId(@PathVariable Long id, 
            @RequestPart(value = "educacionLogo") MultipartFile file,
            @RequestPart ("institucion") String institucion, 
            @RequestPart ("nombreCurso") String nombreCurso,
            @RequestPart ("fechaIngresoCursoStr") String fechaIngresoCursoStr, 
            @RequestPart ("fechaEgresoCursoStr") String fechaEgresoCursoStr,
            @RequestPart ("educacionDescripcion0") String educacionDescripcion0,
            @RequestPart ("educacionDescripcion1") String educacionDescripcion1,
            @RequestPart ("educacionDescripcion2") String educacionDescripcion2)
            throws IOException, ParseException{
        
        Educacion detallesEducacion = new Educacion ();
        
        if(file.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Upload a non-empty file");
        } else {
            
            //conversion variable tipo string a Date ya que FormData no acepta variable tipo Date 
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaIngresoCurso = LocalDate.parse(fechaIngresoCursoStr, df);
            LocalDate fechaEgresoCurso = LocalDate.parse(fechaEgresoCursoStr, df);
            
            System.out.println("educacion cargada exitosamente!!");
            
            //guardar educacion en base de datos
            detallesEducacion.setInstitucion(institucion);
            detallesEducacion.setNombreCurso(nombreCurso);
            detallesEducacion.setFechaIngresoCurso(fechaIngresoCurso);
            detallesEducacion.setFechaEgresoCurso(fechaEgresoCurso);
            detallesEducacion.setEducacionDescripcion0(educacionDescripcion0);
            detallesEducacion.setEducacionDescripcion1(educacionDescripcion1);
            detallesEducacion.setEducacionDescripcion2(educacionDescripcion2);
            detallesEducacion.setEducacionLogo(file.getBytes());
        }
        Educacion educacionActualizado = EducacionService.actualizarEducacionPorId(id, detallesEducacion);
        return ResponseEntity.ok(educacionActualizado);
    }
    
    //metodo eliminar educacion
    @DeleteMapping("/empleados/educaciones/{id}")
    public void eliminarEducacion(@PathVariable Long id){
        EducacionService.eliminarEducacion(id);
    }
}
