/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.controller;

import com.proyectointegradorv1.proyectointegradorv1.model.Skills;
import com.proyectointegradorv1.proyectointegradorv1.service.SkillsServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//API Rest
@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins="http://localhost:4200")
public class SkillsController {
    
    @Autowired
    private SkillsServiceImpl SkillsService;
    
    //metodo para listar todas las skills  
    @GetMapping("/empleados/skills")
    public List<Skills> listarTodasLasSkills(){
        return SkillsService.listarTodasLasSkills();
    }
    
    //metodo guardar skill
    @PostMapping("/empleados/skills")
    public Skills guardarSkills(@RequestBody Skills skill){
        return SkillsService.guardarSkills(skill);
    }
    
    //metodo buscar skill por id
    @GetMapping("/empleados/skills/{id}")
    public ResponseEntity<Skills> obtenerSkillsPorId(@PathVariable Long id){
        Skills skill = SkillsService.obtenerSkillsPorId(id);
        return ResponseEntity.ok(skill);
    }
    
    //metodo editar skill por id
    @PutMapping("/empleados/skills/{id}")
    public ResponseEntity<Skills> actualizarSkillsPorId(@PathVariable Long id, @RequestBody Skills detallesSkill){
        Skills skillActualizada = SkillsService.actualizarSkillsPorId(id, detallesSkill);
        return ResponseEntity.ok(skillActualizada);
    }
    
    //metodo eliminar skill
    @DeleteMapping("/empleados/skills/{id}")
    public void eliminarSkill(@PathVariable Long id){
        SkillsService.eliminarSkills(id);
    }
}
