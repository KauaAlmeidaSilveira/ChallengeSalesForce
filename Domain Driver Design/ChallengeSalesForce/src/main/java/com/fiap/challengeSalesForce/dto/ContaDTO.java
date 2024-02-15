package com.fiap.challengeSalesForce.dto;

import com.fiap.challengeSalesForce.entities.Conta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContaDTO {

    private Long id;
    private String usuario;
    private String email;
    private String senha;
    private String status;
    private LocalDate dataRegistro;
    private LocalDateTime ultimoAcesso;

    private Long pessoaId;

    public ContaDTO() {
    }

    public ContaDTO(Long id, String usuario, String email, String senha, String status, Long pessoaId) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.status = status;
        this.pessoaId = pessoaId;
    }

    public ContaDTO(Conta conta) {
        id = conta.getId();
        usuario = conta.getUsuario();
        email = conta.getEmail();
        senha = conta.getSenha();
        status = conta.getStatus();
        dataRegistro = conta.getDataRegistro();
        ultimoAcesso = conta.getUltimoAcesso();
        pessoaId = conta.getPessoa().getId();
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public Long getPessoaId() {
        return pessoaId;
    }
}
