package com.fiap.challengeSalesForce.dto;

import com.fiap.challengeSalesForce.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EnderecoDTO {

    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String estadoProvincia;

    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "\\d{8}", message = "CEP deve ter no mínimo 8 caracteres")
    private String cep;

    @NotBlank(message = "PAIS é obrigatório")
    private String pais;

    public EnderecoDTO(Long id, String rua, String numero, String cidade, String estadoProvincia, String cep, String pais) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estadoProvincia = estadoProvincia;
        this.cep = cep;
        this.pais = pais;
    }

    public EnderecoDTO(Endereco endereco) {
        id = endereco.getId();
        rua = endereco.getRua();
        numero = endereco.getNumero();
        cidade = endereco.getCidade();
        estadoProvincia = endereco.getEstadoProvincia();
        cep = endereco.getCep();
        pais = endereco.getPais();
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstadoProvincia() {
        return estadoProvincia;
    }

    public String getCep() {
        return cep;
    }

    public String getPais() {
        return pais;
    }
}
