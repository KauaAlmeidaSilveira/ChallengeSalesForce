package model.entities;

import java.util.Objects;

public class Endereco {

    private Integer id;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    public Endereco(String rua, String cidade) {
        this.rua = rua;
        this.cidade = cidade;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
        return Objects.equals(rua, endereco.rua) && Objects.equals(cidade, endereco.cidade) && Objects.equals(estado, endereco.estado) && Objects.equals(cep, endereco.cep) && Objects.equals(pais, endereco.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, cidade, estado, cep, pais);
    }

    @Override
    public String toString() {
        return "\nId: "+ id + "\n" +
                "Rua: "+ rua + "\n" +
                "Cidade: " + cidade + "\n" +
                "Estado: " + estado + "\n" +
                "CEP: " + cep + "\n" +
                "Pais: " + pais;
    }

}
