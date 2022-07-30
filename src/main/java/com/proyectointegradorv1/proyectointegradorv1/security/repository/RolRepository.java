/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.security.repository;

import com.proyectointegradorv1.proyectointegradorv1.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long>{
    
    public Optional<Rol> findByNombre(String nombre);
    
}
