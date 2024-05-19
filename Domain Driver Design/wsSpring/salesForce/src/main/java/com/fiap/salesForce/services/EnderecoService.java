package com.fiap.salesForce.services;

import com.fiap.salesForce.dto.EnderecoDTO;
import com.fiap.salesForce.dto.Register.EnderecoRegisterDTO;
import com.fiap.salesForce.model.Endereco;
import com.fiap.salesForce.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findAll() {
        return enderecoRepository.findAll().stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public EnderecoDTO insert(EnderecoRegisterDTO body) {
        Endereco newEndereco = new Endereco();
        newEndereco.setPais(body.getPais());
        enderecoRepository.save(newEndereco);
        return new EnderecoDTO(newEndereco);
    }

}
