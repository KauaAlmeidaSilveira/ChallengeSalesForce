package model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Conta {

    private Integer id;
    private String usuario;
    private String email;
    private String senha;
    private LocalDate dataRegistro;
    private LocalDateTime ultimoAcesso;

    private Pessoa pessoa;

    public Conta(Integer id, String email, String senha, Pessoa pessoa) {
        this.id = id;
        this.usuario = pessoa.getNome()+"@force.com";
        this.email = email;
        this.senha = senha;
        this.dataRegistro = LocalDate.now();
        this.pessoa = pessoa;
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

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
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
