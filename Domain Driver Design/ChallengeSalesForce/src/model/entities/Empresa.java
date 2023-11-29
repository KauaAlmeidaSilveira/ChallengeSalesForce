package model.entities;

import java.time.LocalDateTime;

public class Empresa {

    private Integer id;
    private String nome;
    private String departamento;
    private String divisao;
    private String numFuncionario;
    private LocalDateTime inicioDia;
    private LocalDateTime fimDia;

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Empresa(String nome, String departamento, String divisao, String numFuncionario, LocalDateTime inicioDia, LocalDateTime fimDia) {
        this.nome = nome;
        this.departamento = departamento;
        this.divisao = divisao;
        this.numFuncionario = numFuncionario;
        this.inicioDia = inicioDia;
        this.fimDia = fimDia;
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

    public String getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(String numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    public LocalDateTime getInicioDia() {
        return inicioDia;
    }

    public void setInicioDia(LocalDateTime inicioDia) {
        this.inicioDia = inicioDia;
    }

    public LocalDateTime getFimDia() {
        return fimDia;
    }

    public void setFimDia(LocalDateTime fimDia) {
        this.fimDia = fimDia;
    }

    @Override
    public String toString() {
        return "\nId: "+ id + "\n" +
                "Nome: "+ nome + "\n" +
                "Departamento: " + departamento + "\n" +
                "Divisão: " + divisao + "\n" +
                "NumFuncionario: " + numFuncionario + "\n" +
                "Inicio do dia: " + inicioDia + "\n" +
                "Fim do dia: " + fimDia;
    }
}
