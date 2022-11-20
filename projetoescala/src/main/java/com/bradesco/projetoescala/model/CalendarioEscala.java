package com.bradesco.projetoescala.model;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = "CalendarioEscala")
@Data
public class CalendarioEscala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn (name= "id_funcionario")
    private Funcionario funcionario;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private Boolean treinamento;
}
