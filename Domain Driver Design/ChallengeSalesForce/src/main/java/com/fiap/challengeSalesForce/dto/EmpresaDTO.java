package com.fiap.challengeSalesForce.dto;

import com.fiap.challengeSalesForce.entities.Empresa;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public class EmpresaDTO {

    private Long id;
    @NotBlank
    private String nome;
    private String departamento;
    private String divisao;
    private String numFuncionario;
    private LocalTime inicioJornada;
    private LocalTime fimJornada;

    public EmpresaDTO(Long id, String nome, String departamento, String divisao, String numFuncionario, LocalTime inicioJornada, LocalTime fimJornada) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.divisao = divisao;
        this.numFuncionario = numFuncionario;
        this.inicioJornada = inicioJornada;
        this.fimJornada = fimJornada;
    }

    public EmpresaDTO(Empresa empresa) {
        id = empresa.getId();
        nome = empresa.getNome();
        departamento = empresa.getDepartamento();
        divisao = empresa.getDivisao();
        numFuncionario = empresa.getNumFuncionario();
        inicioJornada = empresa.getInicioJornada();
        fimJornada = empresa.getFimJornada();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getDivisao() {
        return divisao;
    }

    public String getNumFuncionario() {
        return numFuncionario;
    }

    public LocalTime getInicioJornada() {
        return inicioJornada;
    }

    public LocalTime getFimJornada() {
        return fimJornada;
    }
}
