package com.fiap.challengeSalesForce.dto;

import com.fiap.challengeSalesForce.entities.Conta;
import com.fiap.challengeSalesForce.entities.enums.AccountStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContaDTO {

    private Long id;
    private String usuario;
    @NotBlank
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "O email deve seguir o formato convencional !! Ex: teste@gmail.com")
    private String email;
    @Pattern(regexp = "\\d{6}", message = "A senha deve conter apenas seis digitos numericos !!")
    private String senha;
    private LocalDate dataRegistro;
    private LocalDateTime ultimoAcesso;

    private Long pessoaId;

    public ContaDTO() {
    }

    public ContaDTO(Long id, String usuario, String email, String senha, Long pessoaId) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.pessoaId = pessoaId;
    }

    public ContaDTO(Conta conta) {
        id = conta.getId();
        usuario = conta.getUsuario() + "@salesforce.com";
        email = conta.getEmail();
        senha = conta.getSenha();
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
