package com.bradesco.projetoescala.controller;


import com.bradesco.projetoescala.model.Funcionario;
import com.bradesco.projetoescala.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")

public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/{id}")
    public Funcionario getFuncionario(@PathVariable Integer id) {
        return funcionarioRepository.findById(id).orElse(new Funcionario());
    }

    @GetMapping ("/RegimeDeTrabalho/{regimeDeTrabalho}")
    public List<Funcionario> getFuncionario(@RequestParam(name = "regimeDeTrabalho", required = false) String regimeDeTrabalho) {
        if (regimeDeTrabalho != null) {
            return funcionarioRepository.findByRegimeDeTrabalho(regimeDeTrabalho);
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
        if (funcionarioRepository.existsById(id)) {
         funcionarioRepository.deleteById(id);
            return "Funcionário excluído";
        }
        return "Funcionário não encontrado.";
    }

    @PutMapping("/{id}")
    public String atualizarFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
        Optional <Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isPresent()) {
            Funcionario funcionarioBanco = funcionarioOptional.get();
            funcionarioBanco.setNome(funcionario.getNome());
            funcionarioBanco.setRegimeDeTrabalho(funcionario.getRegimeDeTrabalho());
            funcionarioRepository.save(funcionarioBanco);

            return "Funcionário atualizado";
        }
        return "Funcionario não encontrado";
    }
}


