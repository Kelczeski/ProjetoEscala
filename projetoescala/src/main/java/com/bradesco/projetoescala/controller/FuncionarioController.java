package com.bradesco.projetoescala.controller;


import com.bradesco.projetoescala.model.Funcionario;
import com.bradesco.projetoescala.repository.FuncionarioRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")

public class FuncionarioController {

    @Autowired
    private FuncionarioRepositor funcionarioRepository;

    @GetMapping("/{id}")
    public Funcionario getFuncionario(@PathVariable Integer id) {
        return funcionarioRepository.buscaFuncionario(id);
    }

    @GetMapping
    public List<Funcionario> getFuncionario(@RequestParam(name = "regimeDeTrabalho", required = false) String regimeDeTrabalho) {

        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        if (regimeDeTrabalho != null) {
            return funcionarioRepository.findAllById(regimeDeTrabalho);
        } else {
            return funcionarioRepository.findAll();
        }
    }

    @PostMapping
    public String salvarFuncionario(@RequestBody Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().equals("")) {
            return "O nome do usuário é obrigatório";
        }

        if (funcionario.getRegimeDeTrabalho() == null || funcionario.getRegimeDeTrabalho().equals(""))
            return "O Regime de trabalho é obrigatório";

        funcionarioRepository.save(funcionario);
        return "Cadastro realizado";
    }

    @DeleteMapping("/{id}")
    public String deletarFuncionario(@PathVariable Integer id) {
        boolean deletou = funcionarioRepository.excluirAluno(id);
        if (deletou) {
            return "Funcionário excluído";
        }
        return "Funcionário não encontrado.";
    }

    @PutMapping("/{cpf}")
    public String atualizarFuncionario(@PathVariable Integer id, @RequestBody Funcionario aluno) {
        boolean atualizou = funcionarioRepository.atualizaFuncionario(id, aluno);
        if (atualizou) {
            return "Funcionário atualizado";
        }
        return "Funcionario não encontrado";
    }
}


