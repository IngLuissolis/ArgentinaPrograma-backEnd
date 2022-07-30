/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.security.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerator {
    
    public static void main(String[] args) {

        //metodo que se utiliza para codificar password, en este caso el nombre del password
        //es "admin" y el mismo codificado se imprime por pantalla
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	System.out.println(passwordEncoder.encode("admin"));
        
        //password codificado generado: $2a$10$J7BnI7d3hc5Qu7TRDUOsM.Lo2BM0QUPg3OwbQJ.E.jjW3lnptLz1O
		
    }
    
}
