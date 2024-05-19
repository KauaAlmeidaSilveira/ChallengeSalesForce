package com.fiap.salesForce.services;

import com.fiap.salesForce.dto.ContaResponseDTO;
import com.fiap.salesForce.dto.PessoaDTO;
import com.fiap.salesForce.dto.Register.ContaRegisterDTO;
import com.fiap.salesForce.model.Conta;
import com.fiap.salesForce.repositories.ContaRepository;
import com.fiap.salesForce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<ContaResponseDTO> findAll() {
        return contaRepository.findAll().stream().map(ContaResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public ContaResponseDTO insert(ContaRegisterDTO body, PessoaDTO pessoaDTO, Conta newUser) {
        Conta conta = this.contaRepository.findByEmail(body.getEmail()).orElse(null);

        if (conta == null) {
            newUser.setSenha(passwordEncoder.encode(body.getSenha()));
            newUser.setEmail(body.getEmail());
            newUser.setUsuario(pessoaDTO.getNome() + "." + pessoaDTO.getSobrenome());
            newUser.setStatus("Ativo");
            newUser.setDataRegistro(LocalDate.now());
            newUser.setUltimoAcesso(LocalDateTime.now());
            newUser.setId_pessoa(pessoaDTO.getId_pessoa());
            this.contaRepository.save(newUser);
            return new ContaResponseDTO(newUser);
        }

        return null;
    }

    @Transactional(readOnly = true)
    public boolean findByEmail(String email) {
        Optional<Conta> conta = this.contaRepository.findByEmail(email);
        return conta.isPresent();
    }

}
