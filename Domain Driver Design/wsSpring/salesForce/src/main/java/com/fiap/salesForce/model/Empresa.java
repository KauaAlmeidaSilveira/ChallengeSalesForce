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
@Table(name = "tb_empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empresa;
    private String nome;
    private String departamento;
    private String divisao;
    private String numFuncionario;
    private String inicioJornada;
    private String fimJornada;
}
