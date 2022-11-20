package com.bradesco.projetoescala.repository;

import com.bradesco.projetoescala.model.Funcionario;

import java.util.List;

public interface FuncionarioRepositor {
    Funcionario buscaFuncionario(Integer id);

    List<Funcionario> findAll();

    List<Funcionario> findAllById(String regimeDeTrabalho);

    void save(Funcionario funcionario);

    boolean excluirAluno(Integer id);

    boolean atualizaFuncionario(Integer id, Funcionario aluno);
}
