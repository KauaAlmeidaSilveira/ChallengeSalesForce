package com.fiap.challengeSalesForce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String departamento;
    private String divisao;
    private String numFuncionario;
    @Column(columnDefinition = "TIME")
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime inicioJornada;
    @Column(columnDefinition = "TIME")
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime fimJornada;

    @OneToOne(mappedBy = "empresa")
    private Pessoa pessoa;

    public Empresa() {
    }

    public Empresa(Long id, String nome, String departamento, String divisao, String numFuncionario, LocalTime inicioJornada, LocalTime fimJornada) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.divisao = divisao;
        this.numFuncionario = numFuncionario;
        this.inicioJornada = inicioJornada;
        this.fimJornada = fimJornada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public String getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(String numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    public LocalTime getInicioJornada() {
        return inicioJornada;
    }

    public void setInicioJornada(LocalTime inicioJornada) {
        this.inicioJornada = inicioJornada;
    }

    public LocalTime getFimJornada() {
        return fimJornada;
    }

    public void setFimJornada(LocalTime fimJornada) {
        this.fimJornada = fimJornada;
    }
}
