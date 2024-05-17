package com.fiap.salesForce.services;

import com.fiap.salesForce.dto.ContaDTO;
import com.fiap.salesForce.dto.ServicoDTO;
import com.fiap.salesForce.repositories.ContaRepository;
import com.fiap.salesForce.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Transactional(readOnly = true)
    public List<ContaDTO> findAll() {
        return contaRepository.findAll().stream().map(ContaDTO::new).collect(Collectors.toList());
    }

}
