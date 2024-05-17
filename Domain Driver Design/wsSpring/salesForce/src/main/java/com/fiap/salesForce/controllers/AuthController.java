package com.fiap.salesForce.controllers;

import com.fiap.salesForce.dto.LoginRequestDTO;
import com.fiap.salesForce.dto.RegisterRequestDTO;
import com.fiap.salesForce.dto.ResponseDTO;
import com.fiap.salesForce.model.Conta;
import com.fiap.salesForce.repositories.ContaRepository;
import com.fiap.salesForce.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ContaRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        Conta conta = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("Conta not Found !!"));

        if (passwordEncoder.matches(body.senha(), conta.getSenha())) {
            String token = this.tokenService.generateToken(conta);
            conta.setUltimoAcesso(LocalDateTime.now());
            this.repository.save(conta);
            return ResponseEntity.ok(new ResponseDTO(conta.getUsuario(), token));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<Conta> conta = this.repository.findByEmail(body.email());

        if (conta.isEmpty()) {
            Conta newUser = new Conta();
            newUser.setSenha(passwordEncoder.encode(body.senha()));
            newUser.setEmail(body.email());
            newUser.setUsuario(body.usuario());
            newUser.setStatus("Ativo");
            newUser.setDataRegistro(LocalDate.now());
            newUser.setUltimoAcesso(LocalDateTime.now());
            newUser.setId_pessoa(1L);
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getUsuario(), token));
        }

        return ResponseEntity.badRequest().build();
    }

}
