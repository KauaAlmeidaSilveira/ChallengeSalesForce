package com.fiap.salesForce.dto.Register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRegisterDTO {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
}
