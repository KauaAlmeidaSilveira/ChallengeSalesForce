package com.fiap.salesForce.dto.Register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContaRegisterDTO {
    private String usuario;
    private String email;
    private String senha;
}
