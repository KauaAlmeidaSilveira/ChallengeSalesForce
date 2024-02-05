package com.fiap.challengeSalesForce.services;

import com.fiap.challengeSalesForce.entities.Pessoa;
import com.fiap.challengeSalesForce.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).get();
    }

}
