package com.fiap.salesForce.dto;

import com.fiap.salesForce.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTO {
    private Long id_pessoa;
    private String nome;
    private String sobrenome;
    private String apelido;
    private String telefone;
    private String celular;
    private String rg;
    private String cargo;
    private Long id_empresa;
    private Long id_endereco;

    public PessoaDTO(Pessoa pessoa) {
        this.id_pessoa = pessoa.getId_pessoa();
        this.nome = pessoa.getNome();
        this.sobrenome = pessoa.getSobrenome();
        this.apelido = pessoa.getApelido();
        this.telefone = pessoa.getTelefone();
        this.celular = pessoa.getCelular();
        this.rg = pessoa.getRg();
        this.cargo = pessoa.getCargo();
        this.id_empresa = pessoa.getId_empresa();
        this.id_endereco = pessoa.getId_endereco();
    }
}
