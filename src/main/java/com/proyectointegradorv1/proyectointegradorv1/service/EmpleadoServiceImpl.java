/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.exceptions.ResourceNotFoundException;
import com.proyectointegradorv1.proyectointegradorv1.model.Empleado;
import com.proyectointegradorv1.proyectointegradorv1.repository.EmpleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    
    @Autowired
    private EmpleadoRepository EmpleadoRepo;

    @Override
    public Empleado obtenerEmpleadoPorId(Long id) {
         Empleado empleado = EmpleadoRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe el empleado con id " + id));
        return empleado;
    }

    @Override
    public Empleado actualizarEmpleadoPorId(Long id, Empleado detallesEmpleado) {
         Empleado empleado = EmpleadoRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe el empleado con id " + id));
        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setProfesion(detallesEmpleado.getProfesion());
        empleado.setDireccion(detallesEmpleado.getDireccion());
        empleado.setCelular(detallesEmpleado.getCelular());
        empleado.setEmail(detallesEmpleado.getEmail());
        
        return EmpleadoRepo.save(empleado);
    }

    @Override
    public List<Empleado> listarTodosLosEmpleados() {
         return EmpleadoRepo.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return EmpleadoRepo.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        EmpleadoRepo.deleteById(id);
    }
    
}
