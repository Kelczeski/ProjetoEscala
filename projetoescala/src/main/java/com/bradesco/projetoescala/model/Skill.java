package com.bradesco.projetoescala.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_operador")
    @JsonIgnore

    private List<Funcionario> funcionarios = new ArrayList<>();

    public Skill() {
    }

    public Skill(String id, List<Funcionario> funcionario) {
        this.id = id;
        this.funcionarios = funcionario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
