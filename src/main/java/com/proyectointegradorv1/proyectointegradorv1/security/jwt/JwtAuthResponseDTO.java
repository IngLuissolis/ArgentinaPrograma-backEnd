/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.security.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtAuthResponseDTO {
    
    private String tokenDeAcceso;
    private String tipoDeToken = "Bearer";

    public JwtAuthResponseDTO(String tokenDeAcceso) {
        this.tokenDeAcceso = tokenDeAcceso;
    }

    public JwtAuthResponseDTO(String tokenDeAcceso, String tipoDeToken) {
        super();
        this.tokenDeAcceso = tokenDeAcceso;
        this.tipoDeToken = tipoDeToken;
    }
    
}
