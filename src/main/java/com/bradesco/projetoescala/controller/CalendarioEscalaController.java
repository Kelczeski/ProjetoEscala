package com.bradesco.projetoescala.controller;

import com.bradesco.projetoescala.model.CalendarioEscala;
import com.bradesco.projetoescala.model.Operador;
import com.bradesco.projetoescala.service.CalendarioEscalaService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calendarioescala")
public class CalendarioEscalaController {
    @Autowired
    private CalendarioEscalaService calendarioEscalaService;

    @GetMapping
    public List  listaCalendarioEscala() {
        return calendarioEscalaService.listar();

    }
    @PostMapping
    public String cadastrarEscala(@RequestBody CalendarioEscala calendarioEscala){
        if (calendarioEscala.getFuncionario()==null){
            return "Funcionário é Obrigatório";
        }
        if (calendarioEscala.getHoraEntrada()==null){
            return "Horário de entrada é obrigatório";
        }
        if (calendarioEscala.getHoraSaida()==null){
            return "Horário de saída é obrigatório";
        }
        if (calendarioEscala.getData()==null){
            return "Data é obrigatório";
        }

        calendarioEscala.setData(LocalDate.now());
        boolean cadastrou = calendarioEscalaService.salvar(calendarioEscala);
        if (cadastrou) {
            return "Escala cadastrada com sucesso!";
        } else
            return "Erro, escala não encontrada";
    }

    @DeleteMapping("/{escala")
    public String excluirCalendarioEscala(@PathVariable String escala) {
        boolean deletou = calendarioEscalaService.excluirCalendarioEscala(escala);
        if (deletou){
            return "Escala removida com sucesso";
        }
        return "Escala não encontrada";
    }


    @PutMapping("/{escala")
    public String atualizarCalendarioEscala(@PathVariable String escala, @RequestBody CalendarioEscala calendarioEscala){
        boolean atualizou = calendarioEscalaService.atualizarCalendarioEscala(escala,calendarioEscala);
        if (atualizou) {
            return "Escala atualizada com sucesso";
        }
        return "Escala não encontrada";
}}