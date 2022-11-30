package com.bradesco.projetoescala.repository;

import com.bradesco.projetoescala.controller.CalendarioEscalaController;
import com.bradesco.projetoescala.model.CalendarioEscala;
import org.h2.mvstore.type.StringDataType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarioEscalaRepository extends JpaRepository<CalendarioEscala,Integer> {

    List<CalendarioEscala> getFindByindByFuncionario(String funcionario);
    List<CalendarioEscala> findByData(String DataType);
    List<CalendarioEscala>findByTreinamento(String treinamento);
}
