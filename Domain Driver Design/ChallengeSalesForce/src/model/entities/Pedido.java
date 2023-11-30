package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {

    private Integer ID_Pedido;
    private Conta conta;
    private Servico servico;
    private Pagamento pagamento;
    private LocalDateTime dataPedido;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Pedido() {
    }

    public Pedido(Integer ID_Pedido, Conta conta, Servico servico, Pagamento pagamento) {
        this.ID_Pedido = ID_Pedido;
        this.conta = conta;
        this.servico = servico;
        this.pagamento = pagamento;
        this.dataPedido = LocalDateTime.now();
    }

    public Integer getID_Pedido() {
        return ID_Pedido;
    }

    public void setID_Pedido(Integer ID_Pedido) {
        this.ID_Pedido = ID_Pedido;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return "ID_Pedido: " + ID_Pedido + "\n" +
                "Proprietario da Conta: " + conta.getPessoa().getNome() + "\n" +
                "Servico: " + servico.getNome() + "\n" +
                "Data do Pedido: " + dataPedido.format(fmt)+ "\n" +
                "Pagamento: " + pagamento;

    }
}
