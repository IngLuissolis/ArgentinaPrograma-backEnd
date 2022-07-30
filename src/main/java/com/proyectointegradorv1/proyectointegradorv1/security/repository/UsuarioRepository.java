/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.security.repository;

import com.proyectointegradorv1.proyectointegradorv1.security.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> findByEmail(String email);
    
    public Optional<Usuario> findByUsernameOrEmail(String username,String email);
	
    public Optional<Usuario> findByUsername(String username);
    //comprueba si existe username	
    public Boolean existsByUsername(String username);
    //comprueba si existe email
    public Boolean existsByEmail(String email);
    
}
