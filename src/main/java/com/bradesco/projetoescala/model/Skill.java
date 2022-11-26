package com.bradesco.projetoescala.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "skill")

public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeSkill;


    @ManyToMany
   // @JoinColumn(name = "id_operador")
    @JoinTable(name ="Skill_Func",
    joinColumns = @JoinColumn(name= "skill_id",referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name= "Func_id", referencedColumnName = "ID")
    )
    @JsonIgnore

    private List<Funcionario> funcionarios = new ArrayList<>();

    public Skill() {
    }

    public Skill(Long id) {
        this.id = id;
    }

    public Skill(String nomeSkill) {
        this.nomeSkill = nomeSkill;
    }

    public Skill(String id, List<Funcionario> funcionario) {

        this.funcionarios = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSkill() {
        return nomeSkill;
    }}




