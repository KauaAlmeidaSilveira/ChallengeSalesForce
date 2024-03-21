package com.fiap.challengeSalesForce.dto;

import com.fiap.challengeSalesForce.entities.Pessoa;

public class PessoaDTO {

    private Long id;
    private String nome;
    private String apelido;
    private String telefone;
    private String celular;
    private String cargo;
    private String rg;

    public PessoaDTO(Long id, String nome, String apelido, String telefone, String celular, String cargo, String rg) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.celular = celular;
        this.cargo = cargo;
        this.rg = rg;
    }

    public PessoaDTO(Pessoa pessoa) {
        id = pessoa.getId();
        nome = pessoa.getNome();
        apelido = pessoa.getApelido();
        telefone = pessoa.getTelefone();
        celular = pessoa.getCelular();
        cargo = pessoa.getCargo();
        rg = pessoa.getRg();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getCargo() {
        return cargo;
    }

    public String getRg() {
        return rg;
    }
}
