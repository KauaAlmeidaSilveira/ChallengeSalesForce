package com.fiap.salesForce.dto;

import com.fiap.salesForce.model.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponseDTO {
    private Long id_conta;
    private String usuario;
    private String email;
    private String senha;
    private String status;
    private LocalDate dataRegistro;
    private LocalDateTime ultimoAcesso;
    private Long id_pessoa;

    public ContaResponseDTO(Conta conta){
        this.id_conta = conta.getId_conta();
        this.usuario = conta.getUsuario();
        this.email = conta.getEmail();
        this.senha = conta.getSenha();
        this.status = conta.getStatus();
        this.dataRegistro = conta.getDataRegistro();
        this.ultimoAcesso = conta.getUltimoAcesso();
        this.id_pessoa = conta.getId_pessoa();
    }
}
