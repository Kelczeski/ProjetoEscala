package com.bradesco.projetoescala.repository;

import com.bradesco.projetoescala.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findBySkill(Long id);

    Skill findByNomeSkill(String nomeSkill);

    List<Skill> salvarSkill(String nomeSkill);
}