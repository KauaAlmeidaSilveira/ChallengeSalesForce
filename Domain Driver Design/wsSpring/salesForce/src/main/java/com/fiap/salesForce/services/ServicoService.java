package com.fiap.salesForce.services;

import com.fiap.salesForce.dto.ServicoDTO;
import com.fiap.salesForce.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public List<ServicoDTO> findAll() {
        return servicoRepository.findAll().stream().map(ServicoDTO::new).collect(Collectors.toList());
    }

}
