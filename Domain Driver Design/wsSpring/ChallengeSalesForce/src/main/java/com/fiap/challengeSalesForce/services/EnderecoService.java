package com.fiap.challengeSalesForce.services;

import com.fiap.challengeSalesForce.dto.EnderecoDTO;
import com.fiap.challengeSalesForce.entities.Endereco;
import com.fiap.challengeSalesForce.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoDTO insert(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco();
        copyDtoToEntity(enderecoDTO, endereco);
        endereco = enderecoRepository.save(endereco);
        return new EnderecoDTO(endereco);
    }

    public void copyDtoToEntity(EnderecoDTO enderecoDTO, Endereco endereco){
        endereco.setId(enderecoDTO.getId());
        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstadoProvincia(enderecoDTO.getEstadoProvincia());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setPais(enderecoDTO.getPais());
    }
}
