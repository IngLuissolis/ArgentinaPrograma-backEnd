package com.proyectointegradorv1.proyectointegradorv1;

//import java.util.Arrays;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Proyectointegradorv1Application {
    
    public static void main(String[] args) {
	SpringApplication.run(Proyectointegradorv1Application.class, args);
    }
    
        //Metodo que se utiliza para modelar
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
/*
  @Bean
  CorsConfigurationSource corsConfigurationSource() 
  {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:8080"));
    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }    
*/ 

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("https://portfoliocvonline.firebaseapp.com", "https://portfoliocvonline.web.app/")
//                .allowedOrigins("http://localhost:4200")https://proyectoargentinaprogram-5318e.firebaseapp.com/
//                .allowedOrigins("http://localhost:4200", "http://localhost:8080")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .maxAge(3600L)
                        .allowedHeaders("*")
//
                .allowCredentials(true);
            }
        };
    }

}
