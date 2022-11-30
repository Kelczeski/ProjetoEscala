package com.bradesco.projetoescala.controller;

import com.bradesco.projetoescala.model.Skill;
import com.bradesco.projetoescala.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/{skill}")
    public Skill getSkill(@PathVariable Long id) {
        return skillRepository.findById(id).orElse((new Skill()));
    }

    @PostMapping
    public String salvarSkill(@RequestBody Skill skill) {
        if (skill.getNomeSkill() == null || skill.getNomeSkill().equals("")) {
            return "O nome do skill é obrigatório";
        }
        return "Cadastro realizado";
    }

    @DeleteMapping("/{id}")
    public String deleteSkill(@PathVariable Integer id) {
        if (skillRepository.existsById(Long.valueOf(id))) {
            skillRepository.deleteById(Long.valueOf(id));
            return "Skill excluído";
        }
        return "Skill não encontrado.";

}}
