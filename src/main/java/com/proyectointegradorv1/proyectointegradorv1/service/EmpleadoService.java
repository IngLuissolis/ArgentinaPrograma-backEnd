/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.model.Empleado;
import java.util.List;


public interface EmpleadoService {
    
    public Empleado obtenerEmpleadoPorId(Long id);
    
    public Empleado actualizarEmpleadoPorId(Long id, Empleado detallesEmpleado);
    
    public List<Empleado> listarTodosLosEmpleados();
    
    public Empleado guardarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(Long id);
    
}
