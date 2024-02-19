package com.fiap.challengeSalesForce.dto;

import com.fiap.challengeSalesForce.entities.Pessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PessoaAllAttributesDTO {

    private Long id;
    @NotBlank(message = "Nome é obrigatório !!")
    private String nome;
    private String apelido;
    private String telefone;
    @NotBlank(message = "Celular é obrigatório !!")
    @Pattern(regexp = "\\d{11}", message = "O número deve conter ao menos 11 caracteres !!")
    private String celular;
    @NotBlank(message = "Cargo é obrigatório !!")
    private String cargo;
    private String rg;

    @Valid
    @NotNull(message = "Endereço é obrigatório !!")
    private EnderecoDTO endereco;

    @Valid
    @NotNull(message = "Empresa é obrigatório !!")
    private EmpresaDTO empresa;

    public PessoaAllAttributesDTO(Long id, String nome, String apelido, String telefone, String celular, String cargo, String rg, EnderecoDTO endereco, EmpresaDTO empresa) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.celular = celular;
        this.cargo = cargo;
        this.rg = rg;
        this.endereco = endereco;
        this.empresa = empresa;
    }

    public PessoaAllAttributesDTO(Pessoa pessoa) {
        id = pessoa.getId();
        nome = pessoa.getNome();
        apelido = pessoa.getApelido();
        telefone = pessoa.getTelefone();
        celular = pessoa.getCelular();
        cargo = pessoa.getCargo();
        rg = pessoa.getRg();
        endereco = new EnderecoDTO(pessoa.getEndereco());
        empresa = new EmpresaDTO(pessoa.getEmpresa());
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

    public EmpresaDTO getEmpresa() {
        return empresa;
    }
}
