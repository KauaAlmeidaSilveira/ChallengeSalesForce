package com.fiap.salesForce.dto.Register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRegisterDTO {
    private String nome;
    private String sobrenome;
    private String cargo;
}
