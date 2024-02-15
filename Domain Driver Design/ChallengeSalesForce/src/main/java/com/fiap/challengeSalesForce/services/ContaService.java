package com.fiap.challengeSalesForce.services;

import com.fiap.challengeSalesForce.dto.ContaDTO;
import com.fiap.challengeSalesForce.entities.Conta;
import com.fiap.challengeSalesForce.repositories.ContaRepository;
import com.fiap.challengeSalesForce.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<ContaDTO> findAll() {
        return repository.findAll().stream().map(ContaDTO::new).toList();
    }

    @Transactional
    public ContaDTO findById(Long id) {
        Conta conta = repository.findById(id).get();
        conta.setUltimoAcesso(LocalDateTime.now());
        return new ContaDTO(repository.save(conta));
    }

    @Transactional
    public ContaDTO insert(ContaDTO contaDTO) {
        Conta conta = new Conta();
        copyDtoToEntity(contaDTO, conta);
        conta = repository.save(conta);
        return new ContaDTO(conta);
    }

    private void copyDtoToEntity(ContaDTO contaDTO, Conta conta){
        conta.setId(contaDTO.getId());
        conta.setUsuario(contaDTO.getUsuario());
        conta.setEmail(contaDTO.getEmail());
        conta.setSenha(contaDTO.getSenha());
        conta.setStatus(contaDTO.getStatus());
        conta.setDataRegistro(LocalDate.now());
        conta.setUltimoAcesso(LocalDateTime.now());
        conta.setPessoa(pessoaRepository.getReferenceById(contaDTO.getPessoaId()));
    }
}
