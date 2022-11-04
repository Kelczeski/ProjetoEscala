package com.bradesco.projetoescala.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FuncionarioControleOperacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String responsavel;

    private String eMail;

    private String skill;

    public FuncionarioControleOperacional() {
    }

    public FuncionarioControleOperacional(String responsavel, String eMail, String skill) {
        this.responsavel = responsavel;
        this.eMail = eMail;
        this.skill = skill;
    }

    public String getResponsavel() {
        return responsavel;

    }

    public String geteMail() {
        return eMail;
    }

    public String getSkill() {
        return skill;
    }
}
