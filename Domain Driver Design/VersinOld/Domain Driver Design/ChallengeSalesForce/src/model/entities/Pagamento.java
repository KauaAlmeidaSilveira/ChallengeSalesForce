package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class Pagamento {

    private UUID id;
    private LocalDateTime dataPagamento;
    private Double valorTotal;
    private String metodo;
    private Integer parcelas;
    private Double valorParcelas;
    private String descricao;
    private String status;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Pagamento(Double valorTotal, String metodo, Integer parcelas, String descricao) {
        this.dataPagamento = LocalDateTime.now();
        this.valorTotal = valorTotal;
        this.metodo = metodo;
        this.parcelas = parcelas;
        this.descricao = "Pagamento do serviço " + descricao;
        this.status = "Processando";
        this.valorParcelas = valorTotal/parcelas;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id) && Objects.equals(descricao, pagamento.descricao) && Objects.equals(dataPagamento, pagamento.dataPagamento) && Objects.equals(valorTotal, pagamento.valorTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataPagamento, valorTotal);
    }

    @Override
    public String toString() {
        return "\nId: "+ id + "\n" +
                "Data do Pagamento: "+ dataPagamento.format(fmt) + "\n" +
                "Valor total: " + valorTotal + "\n" +
                "Metodo: " + metodo + "\n" +
                "Parcelas: " + parcelas + "\n" +
                "Valor das Parcelas: " + String.format("%.2f", valorParcelas) + "\n" +
                "Descrição: " + descricao + "\n" +
                "Status: " + status + "\n";
    }
}
