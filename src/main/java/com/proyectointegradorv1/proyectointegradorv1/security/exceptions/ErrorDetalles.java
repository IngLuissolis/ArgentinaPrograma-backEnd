/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.security.exceptions;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorDetalles {
    
    private Date marcaDeTiempo;
    private String mensaje;
    private String detalles;

    public ErrorDetalles() {
    }

    public ErrorDetalles(Date marcaDeTiempo, String mensaje, String detalles) {
        this.marcaDeTiempo = marcaDeTiempo;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
  
}
