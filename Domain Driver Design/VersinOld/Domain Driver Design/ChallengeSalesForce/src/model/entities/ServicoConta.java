package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServicoConta {

    private Integer ID_ServicoConta;
    private Servico servico;
    private Conta conta;
    private String status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public ServicoConta(Integer ID_ServicoConta, Servico servico, Conta conta) {
        this.ID_ServicoConta = ID_ServicoConta;
        this.servico = servico;
        this.conta = conta;
        this.dataInicio = LocalDateTime.now();
        this.status = "Ativo";
    }

    public Integer getID_ServicoConta() {
        return ID_ServicoConta;
    }

    public void setID_ServicoConta(Integer ID_ServicoConta) {
        this.ID_ServicoConta = ID_ServicoConta;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public String toString() {

        String dataTerminoStr = (dataTermino != null) ? dataTermino.format(fmt) : "N/A";

        return  servico.toStringMeuServico()+ "\n" +
                "Status= " + status + "\n" +
                "Data de Inicio= " + dataInicio.format(fmt) + "\n" +
                "Data de Termino= " + dataTerminoStr;
    }
}
