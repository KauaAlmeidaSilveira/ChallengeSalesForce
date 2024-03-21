package model.entities;

import java.time.Instant;

public class Empresa {

    private Integer id;
    private String nome;
    private String departamento;
    private String divisao;
    private Integer numFuncionario;
    private Instant inicioJornada;
    private Instant fimJornada;

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Empresa(String nome, String departamento, String divisao, Integer numFuncionario, Instant inicioJornada, Instant fimJornada) {
        this.nome = nome;
        this.departamento = departamento;
        this.divisao = divisao;
        this.numFuncionario = numFuncionario;
        this.inicioJornada = inicioJornada;
        this.fimJornada = fimJornada;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public Integer getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(Integer numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    public Instant getInicioJornada() {
        return inicioJornada;
    }

    public void setInicioJornada(Instant inicioJornada) {
        this.inicioJornada = inicioJornada;
    }

    public Instant getFimJornada() {
        return fimJornada;
    }

    public void setFimJornada(Instant fimJornada) {
        this.fimJornada = fimJornada;
    }

    @Override
    public String toString() {
        return "\nId: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Departamento: " + departamento + "\n" +
                "Divisão: " + divisao + "\n" +
                "NumFuncionario: " + numFuncionario + "\n" +
                "Inicio da Jornada: " + inicioJornada + "\n" +
                "Fim da Jornada: " + fimJornada;
    }
}
