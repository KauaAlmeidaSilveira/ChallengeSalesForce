package model.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pedido {

    private Long id;
    private Conta conta;
    private Servico servico;
    private Pagamento pagamento;
    private String dataPedido;

    public Pedido() {
    }

    public Pedido(Long id, Conta conta, Servico servico, Pagamento pagamento, String dataPedido) {
        this.id = id;
        this.conta = conta;
        this.servico = servico;
        this.pagamento = pagamento;
        this.dataPedido = dataPedido;
    }

    public Pedido(Conta conta, Servico servico, Pagamento pagamento) {
        this.conta = conta;
        this.servico = servico;
        this.pagamento = pagamento;
        this.dataPedido = LocalDate.now().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(conta, pedido.conta) && Objects.equals(servico, pedido.servico) && Objects.equals(pagamento, pedido.pagamento) && Objects.equals(dataPedido, pedido.dataPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conta, servico, pagamento, dataPedido);
    }

    @Override
    public String toString() {
        return "Pedido " + id + "# \n" +
                "Data do pedido: " + dataPedido + "\n\n" +
                conta + "\n" +
                servico + "\n" +
                pagamento + "\n" +
                "------------------------------------\n";
    }
}
