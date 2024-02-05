package com.fiap.challengeSalesForce.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tb_conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String email;
    private String senha;
    private String status;
    private LocalTime dataRegistro;
    private LocalDateTime ultimoAcesso;

    @OneToOne
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(Long id, String usuario, String email, String senha, String status, LocalTime dataRegistro, LocalDateTime ultimoAcesso, Pessoa pessoa) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.status = status;
        this.dataRegistro = dataRegistro;
        this.ultimoAcesso = ultimoAcesso;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
