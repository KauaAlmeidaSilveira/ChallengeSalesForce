package model.entities;

import java.util.Objects;

public class ServicoConta {

    private Integer id_Servico;
    private Integer id_Conta;
    private String status;
    private String dataInicio;
    private String dataTermino;

    public ServicoConta() {
    }

    public ServicoConta(Integer id_Servico, Integer id_Conta, String status, String dataInicio, String dataTermino) {
        this.id_Servico = id_Servico;
        this.id_Conta = id_Conta;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public ServicoConta(Integer id_Servico, Integer id_Conta, String dataInicio) {
        this.id_Servico = id_Servico;
        this.id_Conta = id_Conta;
        this.status = "ATIVO";
        this.dataInicio = dataInicio;
    }


    public Integer getId_Servico() {
        return id_Servico;
    }

    public void setId_Servico(Integer id_Servico) {
        this.id_Servico = id_Servico;
    }

    public Integer getId_Conta() {
        return id_Conta;
    }

    public void setId_Conta(Integer id_Conta) {
        this.id_Conta = id_Conta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoConta that = (ServicoConta) o;
        return Objects.equals(id_Servico, that.id_Servico) && Objects.equals(id_Conta, that.id_Conta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Servico, id_Conta);
    }
}
