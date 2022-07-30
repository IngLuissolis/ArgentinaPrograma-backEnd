/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.controller;

import com.proyectointegradorv1.proyectointegradorv1.model.Empleado;
import com.proyectointegradorv1.proyectointegradorv1.service.EmpleadoServiceImpl;
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
//@CrossOrigin(origins="*")
//@CrossOrigin(origins="http://localhost:4200")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoServiceImpl EmpleadoService;
    
    //metodo para listar todos los empleados
    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados(){
        return EmpleadoService.listarTodosLosEmpleados();
    }
    
    //metodo guardar empleado
    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return EmpleadoService.guardarEmpleado(empleado);
    }
    
    //metodo buscar empleado por id
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
        Empleado empleado = EmpleadoService.obtenerEmpleadoPorId(id);
        return ResponseEntity.ok(empleado);
    }
    
    //metodo editar empleado por id
    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleadoPorId(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
        Empleado empleadoActualizado = EmpleadoService.actualizarEmpleadoPorId(id, detallesEmpleado);
        return ResponseEntity.ok(empleadoActualizado);
    }
    
    //metodo eliminar empleado
    @DeleteMapping("/empleados/{id}")
    public void eliminarEmpleado(@PathVariable Long id){
        EmpleadoService.eliminarEmpleado(id);
    }
}

