package com.fiap.salesForce.services;

import com.fiap.salesForce.dto.EmpresaDTO;
import com.fiap.salesForce.dto.EnderecoDTO;
import com.fiap.salesForce.dto.PessoaDTO;
import com.fiap.salesForce.dto.Register.PessoaRegisterDTO;
import com.fiap.salesForce.model.Pessoa;
import com.fiap.salesForce.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll().stream().map(PessoaDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public PessoaDTO insert(PessoaRegisterDTO body, EnderecoDTO enderecoDTO, EmpresaDTO empresaDTO) {
            Pessoa newPessoa = new Pessoa();
            newPessoa.setNome(body.getNome());
            newPessoa.setSobrenome(body.getSobrenome());
            newPessoa.setCargo(body.getCargo());
            newPessoa.setId_empresa(enderecoDTO.getId_endereco());
            newPessoa.setId_endereco(empresaDTO.getId_empresa());
            this.pessoaRepository.save(newPessoa);
            return new PessoaDTO(newPessoa);
    }
}
