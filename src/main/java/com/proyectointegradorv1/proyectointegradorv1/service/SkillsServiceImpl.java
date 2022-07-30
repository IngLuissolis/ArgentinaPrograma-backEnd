/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectointegradorv1.proyectointegradorv1.service;

import com.proyectointegradorv1.proyectointegradorv1.exceptions.ResourceNotFoundException;
import com.proyectointegradorv1.proyectointegradorv1.model.Skills;
import com.proyectointegradorv1.proyectointegradorv1.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsServiceImpl implements SkillsService{
    
    @Autowired
    private SkillsRepository SkillsRepo;

    @Override
    public Skills obtenerSkillsPorId(Long id) {
        Skills skill = SkillsRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe el Skill con id " + id));
        return skill;
    }

    @Override
    public Skills actualizarSkillsPorId(Long id, Skills detallesSkill) {
        Skills skill = SkillsRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No existe el Skill con id " + id));
        skill.setNombreSkill(detallesSkill.getNombreSkill());
        skill.setValorSkill(detallesSkill.getValorSkill());
        skill.setSkillLogo(detallesSkill.getSkillLogo());
        
        return SkillsRepo.save(skill);
    }

    @Override
    public List<Skills> listarTodasLasSkills() {
        return SkillsRepo.findAll();
    }

    @Override
    public Skills guardarSkills(Skills skill) {
        return SkillsRepo.save(skill);
    }

    @Override
    public void eliminarSkills(Long id) {
        SkillsRepo.deleteById(id);
    }
    
}
