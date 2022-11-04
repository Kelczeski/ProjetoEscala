package com.bradesco.projetoescala.controller;


import com.bradesco.projetoescala.model.Operador;
import com.bradesco.projetoescala.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operadores")
public class OperadorController {

    @Autowired

    private OperadorService operadorService;

    // operadores?departamento=SAC
    @GetMapping
    public List<Operador> getOperadores(
       @RequestParam(name = "skill", required = false) String departamento){
        // buscaOperadores
        return operadorService.buscarOperadores(departamento);

    }
    //localhost:8080/operador/939
    @GetMapping("/{cpf}")
    public Operador getOperador(@PathVariable String cpf) { return operadorService.buscarOperadorCpf(cpf); }


    @PostMapping
    public String salvarOperadores(@RequestBody Operador operador) {
        if (operador.getNome() == null || operador.getNome().equals("")) {
            return "O nome do operador é obrigatório";
        }

        if (operador.getCpf() == null || operador.getCpf().equals("")) {
            return "O CPF é obrigatório";
        }

        Operador operador1 = operadorService.buscarOperadorCpf(operador.getCpf());
        if (operador1 != null) {
            return "CPF já cadastrado.";
        }

        operadorService.salvarOperador(operador);
        return "Cadastro efetuado com sucesso!";
    }

    // localhost:8080/operadores/939
    @DeleteMapping("/{cpf}")
    public String deletarOperadores(@PathVariable String cpf) {
        boolean deletou = operadorService.excluirOperador(cpf);
        if (deletou) {
            return "Operador excluído com sucesso!";
        }
        return "Operador não encontrado.";
    }

    @PutMapping("/{cpf}")
    public String atualizarOperador(@PathVariable String cpf, @RequestBody Operador operador) {
        boolean atualizou = operadorService.atualizarOperador(cpf, operador);
        if (atualizou) {
            return "Operador atualizado com sucesso";
        }
        return "Operador não encontrado";
    }

}
