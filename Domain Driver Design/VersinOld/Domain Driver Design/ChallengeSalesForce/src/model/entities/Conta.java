package model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Conta {

    private Integer id;
    private String usuario;
    private String email;
    private String senha;
    private String status;
    private String dataRegistro;
    private String ultimoAcesso;

    private Pessoa pessoa;

    public Conta(String email, String senha, Pessoa pessoa) {
        this.id = 1;
        this.usuario = pessoa.getNome()+"@force.com";
        this.email = email;
        this.senha = senha;
        this.pessoa = pessoa;
        this.status = "Ativo";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(String ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(usuario, conta.usuario) && Objects.equals(email, conta.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, email);
    }

    @Override
    public String toString() {
        return "\nConta " + "\n" +
                "Id: "+ id + "\n" +
                "Proprietario: " + pessoa.getId() + "\n" +
                "Usuario: "+ usuario + "\n" +
                "Email: " + email + "\n" +
                "Senha: " + senha;
    }
}
