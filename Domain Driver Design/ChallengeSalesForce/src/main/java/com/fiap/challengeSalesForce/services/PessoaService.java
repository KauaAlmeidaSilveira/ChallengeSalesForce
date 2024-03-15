package com.fiap.challengeSalesForce.services;

import com.fiap.challengeSalesForce.dto.EmpresaDTO;
import com.fiap.challengeSalesForce.dto.EnderecoDTO;
import com.fiap.challengeSalesForce.dto.PessoaAllAttributesDTO;
import com.fiap.challengeSalesForce.dto.PessoaDTO;
import com.fiap.challengeSalesForce.entities.Pessoa;
import com.fiap.challengeSalesForce.repositories.EmpresaRepository;
import com.fiap.challengeSalesForce.repositories.EnderecoRepository;
import com.fiap.challengeSalesForce.repositories.PessoaRepository;
import com.fiap.challengeSalesForce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    public <T> List<T> findAll(String withAllAttributes, Class<T> returnType) {
        List<T> resultList;

        if (withAllAttributes.toLowerCase().trim().equals("true")) {
            resultList = pessoaRepository.findAll().stream()
                    .map(entity -> returnType.cast(new PessoaAllAttributesDTO(entity)))
                    .toList();
        } else {
            resultList = pessoaRepository.findAll().stream()
                    .map(entity -> returnType.cast(new PessoaDTO(entity)))
                    .toList();
        }
        return resultList;
    }

    @Transactional(readOnly = true)
    public <T> T findById(Long id, String withAllAttributes, Class<T> returnType) {
        if (withAllAttributes.toLowerCase().trim().equals("true")) {
            return returnType.cast(new PessoaAllAttributesDTO(pessoaRepository.findById(id).get()));
        } else {
            return returnType.cast(new PessoaDTO(pessoaRepository.findById(id).get()));
        }
    }

    @Transactional
    public PessoaAllAttributesDTO insert(PessoaAllAttributesDTO pessoaAllAttributesDTO) {
        Pessoa pessoa = new Pessoa();
        EnderecoDTO endereco = enderecoService.insert(pessoaAllAttributesDTO.getEndereco());
        EmpresaDTO empresa = empresaService.insert(pessoaAllAttributesDTO.getEmpresa());
        copyDtoToEntity(pessoaAllAttributesDTO, pessoa, endereco, empresa);
        pessoa = pessoaRepository.save(pessoa);
        return new PessoaAllAttributesDTO(pessoa);
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isEmpty()) {
            throw new ResourceNotFoundException("Pessoa não encontrada");
        }
        pessoaRepository.deleteById(id);

    }

    @Transactional
    public PessoaDTO update(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        updateDtoToEntity(pessoaDTO, pessoa);
        return new PessoaDTO(pessoaRepository.save(pessoa));
    }

    public void updateDtoToEntity(PessoaDTO pessoaDTO, Pessoa pessoa){
        if(pessoaDTO.getNome() != null) pessoa.setNome(pessoaDTO.getNome());
        if(pessoaDTO.getApelido() != null) pessoa.setApelido(pessoaDTO.getApelido());
        if(pessoaDTO.getTelefone() != null) pessoa.setTelefone(pessoaDTO.getTelefone());
        if(pessoaDTO.getCelular() != null) pessoa.setCelular(pessoaDTO.getCelular());
        if(pessoaDTO.getCargo() != null) pessoa.setCargo(pessoaDTO.getCargo());
        if(pessoaDTO.getRg() != null) pessoa.setRg(pessoaDTO.getRg());
    }

    public void copyDtoToEntity(PessoaAllAttributesDTO pessoaAllAttributesDTO, Pessoa pessoa, EnderecoDTO enderecoDTO, EmpresaDTO empresaDTO) {
        pessoa.setId(pessoaAllAttributesDTO.getId());
        pessoa.setNome(pessoaAllAttributesDTO.getNome());
        pessoa.setApelido(pessoaAllAttributesDTO.getApelido());
        pessoa.setTelefone(pessoaAllAttributesDTO.getTelefone());
        pessoa.setCelular(pessoaAllAttributesDTO.getCelular());
        pessoa.setCargo(pessoaAllAttributesDTO.getCargo());
        pessoa.setRg(pessoaAllAttributesDTO.getRg());
        pessoa.setEndereco(enderecoRepository.getReferenceById(enderecoDTO.getId()));
        pessoa.setEmpresa(empresaRepository.getReferenceById(empresaDTO.getId()));
    }
}
