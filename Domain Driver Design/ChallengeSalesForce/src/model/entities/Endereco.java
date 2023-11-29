package model.entities;

import java.util.Objects;

public class Endereco {

    private Integer id;

    private String rua;
    private String cidade;
    private String estado;
    private String CEP;
    private String pais;

    public Endereco(String pais) {
        this.pais = pais;
    }

    public Endereco(String rua, String cidade, String estado, String CEP, String pais) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.CEP = CEP;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(rua, endereco.rua) && Objects.equals(cidade, endereco.cidade) && Objects.equals(estado, endereco.estado) && Objects.equals(CEP, endereco.CEP) && Objects.equals(pais, endereco.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, cidade, estado, CEP, pais);
    }

    @Override
    public String toString() {
        return "\nId: "+ id + "\n" +
                "Rua: "+ rua + "\n" +
                "Cidade: " + cidade + "\n" +
                "Estado: " + estado + "\n" +
                "CEP: " + CEP + "\n" +
                "Pais: " + pais;
    }

}
