package com.bradesco.projetoescala.repository;

import com.bradesco.projetoescala.model.Operador;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperadorRepository extends JpaRepository<Operador, Integer> {

    List<Operador> findBySkill(String skill);

    Operador findByCpf(String cpf);

}
