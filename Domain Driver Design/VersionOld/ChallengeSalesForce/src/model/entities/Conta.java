package model.entities;

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
        this.usuario = pessoa.getNome();
        this.email = email;
        this.senha = senha;
        this.pessoa = pessoa;
        this.status = "Ativo";
    }

    public Conta(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Conta(Integer id, String usuario, String email, String senha, String status, String dataRegistro, String ultimoAcesso, Pessoa pessoa) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.status = status;
        this.dataRegistro = dataRegistro;
        this.ultimoAcesso = ultimoAcesso;
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
        int size = senha.length();
        String senhaEscondida = "*".repeat(size);

        return "Conta " + "\n" +
                "Numero da conta: " + id + "\n" +
                "Nome do proprietario: " + pessoa.getNome() + "\n" +
                "Usuario: " + usuario + "\n" +
                "Email: " + email + "\n" +
                "Senha: " + senhaEscondida + "\n";
    }
}
