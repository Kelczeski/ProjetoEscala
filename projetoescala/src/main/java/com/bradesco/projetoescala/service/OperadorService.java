package com.bradesco.projetoescala.service;

import com.bradesco.projetoescala.model.Operador;
import com.bradesco.projetoescala.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadorService {

  @Autowired
    private OperadorRepository operadorRepository;

    public void salvarOperador (Operador operador) {operadorRepository.save(operador);}

      public List<Operador> buscarOperadores(String departamento) {
      if (departamento !=null) {

       return operadorRepository.findBySkill(departamento);
      } else {
        return operadorRepository.findAll();
      }
  }
  public Operador buscarOperadorCpf(String cpf) { return operadorRepository.findByCpf(cpf); }

    public boolean excluirOperador(String cpf) {
        Operador operador = operadorRepository.findByCpf(cpf);
      if (operador!=null) {
        operadorRepository.delete(operador);
        return true;
      }
      return false;

  }public boolean atualizarOperador(String cpf, Operador operador) {
        Operador operador1 = operadorRepository.findByCpf(cpf);
        if (operador != null) {
            operador1.setNome(operador.getNome());
            operador1.setSkill(operador.getSkill());
            operadorRepository.save(operador1);
            return true;
        }
        return false;
    }
}
