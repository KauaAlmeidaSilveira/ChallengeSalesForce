package com.fiap.challengeSalesForce.dto;

import com.fiap.challengeSalesForce.entities.Endereco;

public class EnderecoDTO {

    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String estadoProvincia;
    private String CEP;
    private String pais;

    public EnderecoDTO(Long id, String rua, String numero, String cidade, String estadoProvincia, String CEP, String pais) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estadoProvincia = estadoProvincia;
        this.CEP = CEP;
        this.pais = pais;
    }

    public EnderecoDTO(Endereco endereco) {
        id = endereco.getId();
        rua = endereco.getRua();
        numero = endereco.getNumero();
        cidade = endereco.getCidade();
        estadoProvincia = endereco.getEstadoProvincia();
        CEP = endereco.getCEP();
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

    public String getCEP() {
        return CEP;
    }

    public String getPais() {
        return pais;
    }
}
