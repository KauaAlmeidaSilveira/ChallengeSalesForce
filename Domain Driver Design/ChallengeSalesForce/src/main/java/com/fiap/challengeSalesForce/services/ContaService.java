package com.fiap.challengeSalesForce.services;

import com.fiap.challengeSalesForce.dto.ContaDTO;
import com.fiap.challengeSalesForce.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Transactional(readOnly = true)
    public List<ContaDTO> getTest() {
        return repository.findAll().stream().map(ContaDTO::new).toList();
    }

}
