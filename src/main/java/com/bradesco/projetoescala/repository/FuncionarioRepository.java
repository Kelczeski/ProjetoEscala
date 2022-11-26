package com.bradesco.projetoescala.repository;
import com.bradesco.projetoescala.controller.FuncionarioController;
import com.bradesco.projetoescala.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer>{
List<Funcionario> findByRegimeDeTrabalho(String regimeDeTrabalho);

}