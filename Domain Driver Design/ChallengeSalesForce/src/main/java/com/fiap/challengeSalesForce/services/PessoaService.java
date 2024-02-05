package com.fiap.challengeSalesForce.services;

import com.fiap.challengeSalesForce.dto.EnderecoDTO;
import com.fiap.challengeSalesForce.dto.PessoaComEnderecoDTO;
import com.fiap.challengeSalesForce.dto.PessoaDTO;
import com.fiap.challengeSalesForce.entities.Pessoa;
import com.fiap.challengeSalesForce.repositories.EnderecoRepository;
import com.fiap.challengeSalesForce.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public <T> List<T> findAll(String pessoaComEndereco, Class<T> returnType) {
        List<T> resultList;

        if (pessoaComEndereco.toLowerCase().trim().equals("true")) {
            resultList = pessoaRepository.findAll().stream()
                    .map(entity -> returnType.cast(new PessoaComEnderecoDTO(entity)))
                    .toList();
        }else {
            resultList = pessoaRepository.findAll().stream()
                    .map(entity -> returnType.cast(new PessoaDTO(entity)))
                    .toList();
        }
        return resultList;
    }

    @Transactional(readOnly = true)
    public <T> T findById(Long id, String pessoaComEndereco, Class<T> returnType) {
        if (pessoaComEndereco.toLowerCase().trim().equals("true")) {
            return returnType.cast(new PessoaComEnderecoDTO(pessoaRepository.findById(id).get()));
        }else {
            return returnType.cast(new PessoaDTO(pessoaRepository.findById(id).get()));
        }
    }

    @Transactional
    public PessoaComEnderecoDTO insert(PessoaComEnderecoDTO pessoaComEnderecoDTO){
        Pessoa pessoa = new Pessoa();
        EnderecoDTO endereco = enderecoService.insert(pessoaComEnderecoDTO.getEndereco());
        copyDtoToEntity(pessoaComEnderecoDTO, pessoa, endereco);
        pessoa = pessoaRepository.save(pessoa);
        return new PessoaComEnderecoDTO(pessoa);
    }

    public void copyDtoToEntity(PessoaComEnderecoDTO pessoaComEnderecoDTO, Pessoa pessoa, EnderecoDTO enderecoDTO){
        pessoa.setId(pessoaComEnderecoDTO.getId());
        pessoa.setNome(pessoaComEnderecoDTO.getNome());
        pessoa.setApelido(pessoaComEnderecoDTO.getApelido());
        pessoa.setTelefone(pessoaComEnderecoDTO.getTelefone());
        pessoa.setCelular(pessoaComEnderecoDTO.getCelular());
        pessoa.setCargo(pessoaComEnderecoDTO.getCargo());
        pessoa.setRg(pessoaComEnderecoDTO.getRg());
        pessoa.setEndereco(enderecoRepository.getReferenceById(enderecoDTO.getId()));
    }
}
