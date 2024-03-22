package model.entities;

import java.util.Objects;

public class Pessoa {

    private Integer id;

    private String nome;
    private String apelido;
    private String telefone;
    private String celular;
    private String rg;
    private String cargo;

    private Empresa empresa;
    private Endereco endereco;

    public Pessoa(String nome, String apelido, String telefone, String celular, String rg, String cargo, Empresa empresa, Endereco endereco) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.celular = celular;
        this.rg = rg;
        this.cargo = cargo;
        this.empresa = empresa;
        this.endereco = endereco;
    }

    public Pessoa(String nome, String celular, String cargo, String rg, Empresa empresa, Endereco endereco) {
        this.nome = nome;
        this.celular = celular;
        this.cargo = cargo;
        this.rg = rg;
        this.empresa = empresa;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(rg, pessoa.rg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, rg);
    }

    @Override
    public String toString() {
        return "\nPessoa " + "\n" +
                "Id: "+ id + "\n" +
                "Nome: "+ nome + "\n" +
                "Apelido: " + apelido + "\n" +
                "Telefone: " + telefone + "\n" +
                "Celular: " + celular + "\n" +
                "RG: " + rg + "\n\n" +
                "Empresa " + empresa + "\n\n" +
                "Endereço " + endereco + "\n";
    }
}
