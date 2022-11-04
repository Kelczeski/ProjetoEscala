package com.bradesco.projetoescala.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Operador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String skill;

    private String cpf;

    private String equipeSupervidorResponsavel;

    @OneToMany(mappedBy = "skill")
    private List<Operador> operador = new ArrayList<>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEquipeSupervidorResponsavel() {
        return equipeSupervidorResponsavel;
    }

    public void setEquipeSupervidorResponsavel(String equipeSupervidorResponsavel) {
        this.equipeSupervidorResponsavel = equipeSupervidorResponsavel;
    }
}