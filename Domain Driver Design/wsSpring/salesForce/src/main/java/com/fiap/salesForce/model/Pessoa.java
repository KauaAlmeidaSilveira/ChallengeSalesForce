package com.fiap.salesForce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
