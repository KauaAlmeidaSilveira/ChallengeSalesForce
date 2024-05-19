package com.fiap.salesForce.dto;

import com.fiap.salesForce.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpresaDTO {
    private Long id_empresa;
    private String nome;
    private String departamento;
    private String divisao;
    private String numFuncionario;
    private String inicioJornada;
    private String fimJornada;

    public EmpresaDTO(Empresa empresa) {
        this.id_empresa = empresa.getId_empresa();
        this.nome = empresa.getNome();
        this.departamento = empresa.getDepartamento();
        this.divisao = empresa.getDivisao();
        this.numFuncionario = empresa.getNumFuncionario();
        this.inicioJornada = empresa.getInicioJornada();
        this.fimJornada = empresa.getFimJornada();
    }

}
