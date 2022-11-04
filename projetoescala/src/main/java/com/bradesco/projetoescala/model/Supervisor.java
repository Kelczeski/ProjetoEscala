package com.bradesco.projetoescala.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nome;

    private String Email;


    public Supervisor() {
    }

    public Supervisor(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        Email = email;
    }

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
