package model.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pagamento {

    private Integer id;
    private String dataPagamento;
    private Double valorTotal;
    private String formaPagamento;
    private Integer parcelas;
    private Double valorParcelas;
    private String descricao;
    private String status;


    public Pagamento() {
    }

    public Pagamento(Integer id, String dataPagamento, Double valorTotal, String formaPagamento, Integer parcelas, Double valorParcelas, String descricao, String status) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.valorParcelas = valorParcelas;
        this.descricao = descricao;
        this.status = status;
    }

    public Pagamento(String formaPagamento, Integer parcelas, Servico servico) {
        this.dataPagamento = LocalDate.now().toString();
        this.valorTotal = servico.getValor();
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.valorParcelas = valorTotal / parcelas;
        this.descricao = servico.getDescricao();
        this.status = "Ativo";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
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
        return Objects.equals(id, pagamento.id) && Objects.equals(dataPagamento, pagamento.dataPagamento) && Objects.equals(valorTotal, pagamento.valorTotal) && Objects.equals(formaPagamento, pagamento.formaPagamento) && Objects.equals(parcelas, pagamento.parcelas) && Objects.equals(valorParcelas, pagamento.valorParcelas) && Objects.equals(descricao, pagamento.descricao) && Objects.equals(status, pagamento.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataPagamento, valorTotal, formaPagamento, parcelas, valorParcelas, descricao, status);
    }
}
