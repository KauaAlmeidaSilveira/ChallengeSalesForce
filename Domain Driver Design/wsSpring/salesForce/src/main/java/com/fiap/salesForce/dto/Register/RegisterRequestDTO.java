package com.fiap.salesForce.dto.Register;

public record RegisterRequestDTO(
        EnderecoRegisterDTO endereco, EmpresaRegisterDTO empresa,
        PessoaRegisterDTO pessoa, ContaRegisterDTO conta
) {}
