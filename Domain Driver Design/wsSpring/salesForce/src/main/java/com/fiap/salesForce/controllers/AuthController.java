package com.fiap.salesForce.controllers;

import com.fiap.salesForce.dto.*;
import com.fiap.salesForce.dto.Register.RegisterRequestDTO;
import com.fiap.salesForce.model.Conta;
import com.fiap.salesForce.repositories.ContaRepository;
import com.fiap.salesForce.security.TokenService;
import com.fiap.salesForce.services.ContaService;
import com.fiap.salesForce.services.EmpresaService;
import com.fiap.salesForce.services.EnderecoService;
import com.fiap.salesForce.services.PessoaService;
import com.fiap.salesForce.services.exceptions.ResourceNotFoundException;
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
        Conta conta = this.contaRepository.findByEmail(body.email()).orElseThrow(() -> new ResourceNotFoundException("Email não encontrado"));

        if (passwordEncoder.matches(body.senha(), conta.getSenha()) && conta.getEmail() != null) {
            String token = this.tokenService.generateToken(conta);
            conta.setUltimoAcesso(LocalDateTime.now());
            this.contaRepository.save(conta);
            return ResponseEntity.ok(new ResponseDTO(conta.getUsuario(), token));
        }

        return ResponseEntity.status(400).body(new ErroDTO("Dados inválidos"));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        EnderecoDTO enderecoDTO = enderecoService.insert(body.endereco());
        EmpresaDTO empresaDTO = empresaService.insert(body.empresa());
        PessoaDTO pessoaDTO = pessoaService.insert(body.pessoa(), enderecoDTO, empresaDTO);

        Conta conta = new Conta();
        if (pessoaDTO.getId_pessoa() != null) {
            ContaResponseDTO resultInsert = contaService.insert(body.conta(), pessoaDTO, conta);
            if (resultInsert == null) {
                return ResponseEntity.status(400).body(new ErroDTO("Email já cadastrado"));
            }
        }

        String token = this.tokenService.generateToken(conta);
        return ResponseEntity.ok(new ResponseDTO(conta.getUsuario(), token));
    }

}
