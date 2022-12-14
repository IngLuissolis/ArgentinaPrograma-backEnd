/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.security.jwt;

import com.proyectointegradorv1.proyectointegradorv1.security.exceptions.BlogAppException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    
    @Value("${app.jwt-secret}")
    private String jwtSecret;
	
    @Value("${app.jwt-expiration-miliseconds}")
    private int jwtExpirationInMs;
    
    public String generarToken(Authentication authentication) {
	String username = authentication.getName();
	Date fechaActual = new Date();
	Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpirationInMs);
		
	String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
		.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		
	return token;
    }
    
    public String obtenerUsernameDelJWT(String token) {
        //Claims - solicitudes del Token
	Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	return claims.getSubject();
    }
    
    public boolean validarToken(String token) {
	try {
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		return true;
	}catch (SignatureException ex) {
		throw new BlogAppException(HttpStatus.BAD_REQUEST,"Firma JWT no valida");
	}
	catch (MalformedJwtException ex) {
		throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT no valida");
	}
	catch (ExpiredJwtException ex) {
		throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT caducado");
	}
	catch (UnsupportedJwtException ex) {
		throw new BlogAppException(HttpStatus.BAD_REQUEST,"Token JWT no compatible");
	}
	catch (IllegalArgumentException ex) {
		throw new BlogAppException(HttpStatus.BAD_REQUEST,"La cadena claims JWT esta vacia");
        }
    }
    
}
