package com.fiap.salesForce.dto;

import com.fiap.salesForce.model.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {
    private Integer id_servico;
    private String nome;
    private String descricao;
    private String categoria;
    private Double valor;

    public ServicoDTO(Servico servico) {
        this.id_servico = servico.getId_servico();
        this.nome = servico.getNome();
        this.descricao = servico.getDescricao();
        this.categoria = servico.getCategoria();
        this.valor = servico.getValor();
    }
}
