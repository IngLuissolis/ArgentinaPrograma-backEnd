/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.security;

//clase de seguridad personalizada

import com.proyectointegradorv1.proyectointegradorv1.security.jwt.JwtAuthenticationEntryPoint;
import com.proyectointegradorv1.proyectointegradorv1.security.jwt.JwtAuthenticationFilter;
import com.proyectointegradorv1.proyectointegradorv1.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
	return new JwtAuthenticationFilter();
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors(); //faltaba esto agregar para que no de error de Access-Control-Allow-Origin
        http.csrf().disable()
                .exceptionHandling()
		.authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest()
		.authenticated();
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
    }    
    
    
 /* //Metodo que se usa para probar usuario luis y admin, se guardaban en memoria  
    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails luis = User.builder().username("luis").password(passwordEncoder().encode("password")).roles("USER").build();
        
        //Configuracion Usuario administrador
        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
        
        return new InMemoryUserDetailsManager(luis, admin);
    }
 */   
}
