package com.bradesco.projetoescala.service;


import com.bradesco.projetoescala.model.CalendarioEscala;
import com.bradesco.projetoescala.repository.CalendarioEscalaRepository;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalendarioEscalaService {

    @Autowired
    private CalendarioEscalaRepository calendarioEscalaRepository;

    public boolean salvar(CalendarioEscala calendarioEscala){
        return false;
    }

    public boolean excluirCalendarioEscala(String escala) {
        return false;
    }

    public boolean atualizarCalendarioEscala(String escala, CalendarioEscala calendarioEscala) {
        return false;
    }

    public List listar() {
        return null;
    }
}


