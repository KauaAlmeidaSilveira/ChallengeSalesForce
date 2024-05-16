package com.fiap.salesForce.dto;

import com.fiap.salesForce.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDTO {
    private Long id_endereco;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    public EnderecoDTO(Endereco endereco) {
        this.id_endereco = endereco.getId_endereco();
        this.rua = endereco.getRua();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.cep = endereco.getCep();
        this.pais = endereco.getPais();
    }
}
