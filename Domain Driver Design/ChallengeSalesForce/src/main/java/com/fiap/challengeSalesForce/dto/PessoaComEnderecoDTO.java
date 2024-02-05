package com.fiap.challengeSalesForce.dto;

import com.fiap.challengeSalesForce.entities.Pessoa;

public class PessoaComEnderecoDTO {

    private Long id;
    private String nome;
    private String apelido;
    private String telefone;
    private String celular;
    private String cargo;
    private String rg;

    private EnderecoDTO endereco;

    public PessoaComEnderecoDTO(Long id, String nome, String apelido, String telefone, String celular, String cargo, String rg, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.celular = celular;
        this.cargo = cargo;
        this.rg = rg;
        this.endereco = endereco;
    }

    public PessoaComEnderecoDTO(Pessoa pessoa) {
        id = pessoa.getId();
        nome = pessoa.getNome();
        apelido = pessoa.getApelido();
        telefone = pessoa.getTelefone();
        celular = pessoa.getCelular();
        cargo = pessoa.getCargo();
        rg = pessoa.getRg();
        endereco = new EnderecoDTO(pessoa.getEndereco());
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }
}
