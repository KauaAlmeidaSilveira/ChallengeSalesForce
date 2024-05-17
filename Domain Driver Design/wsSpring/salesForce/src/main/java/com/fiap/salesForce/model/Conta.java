package com.fiap.salesForce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta;
    private String usuario;
    private String email;
    private String senha;
    private String status;
    private LocalDate dataRegistro;
    private LocalDateTime ultimoAcesso;
    private Long id_pessoa;
}
