package model.Entity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;

public class ServicoConta {

    private Integer ID_ServicoConta;
    private Integer ID_Servico;
    private Integer ID_Conta;
    private String status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    public ServicoConta(Integer ID_ServicoConta, Integer ID_Servico, Integer ID_Conta, LocalDateTime dataInicio) {
        this.ID_ServicoConta = ID_ServicoConta;
        this.ID_Servico = ID_Servico;
        this.ID_Conta = ID_Conta;
        this.status = "Ativo";
        this.dataInicio = dataInicio;
    }

    public Integer getID_ServicoConta() {
        return ID_ServicoConta;
    }

    public void setID_ServicoConta(Integer ID_ServicoConta) {
        this.ID_ServicoConta = ID_ServicoConta;
    }

    public Integer getID_Servico() {
        return ID_Servico;
    }

    public void setID_Servico(Integer ID_Servico) {
        this.ID_Servico = ID_Servico;
    }

    public Integer getID_Conta() {
        return ID_Conta;
    }

    public void setID_Conta(Integer ID_Conta) {
        this.ID_Conta = ID_Conta;
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

        return "ServicoConta: {\n" +
                "ID_ServicoConta= " + ID_ServicoConta + "\n" +
                "ID_Conta= " + ID_Conta + "\n" +
                "ID_Servico= " + ID_Servico + "\n" +
                "Status= " + status  + "\n" +
                "Data de Inicio= " + dataInicio.format(fmt) + "\n" +
                "Data de Termino= " + dataTerminoStr + "\n" +
                "}";
    }
}
