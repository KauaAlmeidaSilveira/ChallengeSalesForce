package model.entities;

import java.util.Objects;

public class Servico {

    private Integer id;
    private String nome;
    private String descricao;
    private String categoria;
    private Double valor;

    public Servico(Integer id, String nome, String descricao, String categoria, Double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(nome, servico.nome) && Objects.equals(categoria, servico.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, categoria);
    }

    @Override
    public String toString() {
        return "Serviço: "+ "\n" +
                "Id: "+ id + "\n" +
                "Nome: "+ nome + "\n" +
                "Descrição: " + descricao + "\n" +
                "Categoria: " + categoria + "\n" +
                "Valor: " + valor;
    }

    public String toStringMeuServico() {
        return "Serviço: "+ "\n" +
                "Nome: "+ nome + "\n" +
                "Descrição: " + descricao + "\n" +
                "Categoria: " + categoria;
    }
}
