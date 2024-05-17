package com.fiap.salesForce.controllers;

import com.fiap.salesForce.dto.*;
import com.fiap.salesForce.dto.Register.RegisterRequestDTO;
import com.fiap.salesForce.model.Conta;
import com.fiap.salesForce.model.Empresa;
import com.fiap.salesForce.model.Endereco;
import com.fiap.salesForce.model.Pessoa;
import com.fiap.salesForce.repositories.ContaRepository;
import com.fiap.salesForce.security.TokenService;
import com.fiap.salesForce.services.ContaService;
import com.fiap.salesForce.services.EmpresaService;
import com.fiap.salesForce.services.EnderecoService;
import com.fiap.salesForce.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PessoaService pessoaService;
    private final ContaRepository contaRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final ContaService contaService;
    private final EnderecoService enderecoService;
    private final EmpresaService empresaService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        Conta conta = this.contaRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("Conta not Found !!"));

        if (passwordEncoder.matches(body.senha(), conta.getSenha())) {
            String token = this.tokenService.generateToken(conta);
            conta.setUltimoAcesso(LocalDateTime.now());
            this.contaRepository.save(conta);
            return ResponseEntity.ok(new ResponseDTO(conta.getUsuario(), token));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
        EnderecoDTO enderecoDTO = enderecoService.insert(body.endereco());
        EmpresaDTO empresaDTO = empresaService.insert(body.empresa());
        PessoaDTO pessoaDTO = pessoaService.insert(body.pessoa(), enderecoDTO, empresaDTO);

        Conta conta = new Conta();
        if (pessoaDTO.getId_pessoa() != null) {
            contaService.insert(body.conta(), pessoaDTO, conta);
        }

        String token = this.tokenService.generateToken(conta);
        return ResponseEntity.ok(new ResponseDTO(conta.getUsuario(), token));
    }

}
