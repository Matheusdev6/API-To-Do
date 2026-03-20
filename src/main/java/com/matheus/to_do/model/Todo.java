package com.matheus.to_do.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tarefa_tb")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private LocalDateTime criadoEm = LocalDateTime.now();
    // all args constructor
    public Todo(String titulo, String descricao, Status status, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
    }
    // no args constructor
    public Todo(){}
    public Integer getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}

