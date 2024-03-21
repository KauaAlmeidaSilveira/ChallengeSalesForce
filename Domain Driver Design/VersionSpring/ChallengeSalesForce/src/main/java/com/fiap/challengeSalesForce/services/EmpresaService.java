package com.fiap.challengeSalesForce.services;

import com.fiap.challengeSalesForce.dto.EmpresaDTO;
import com.fiap.challengeSalesForce.entities.Empresa;
import com.fiap.challengeSalesForce.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Transactional
    public EmpresaDTO insert(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        copyDtoToEntity(empresaDTO, empresa);
        repository.save(empresa);
        return new EmpresaDTO(empresa);
    }

    private void copyDtoToEntity(EmpresaDTO empresaDTO, Empresa empresa){
        empresa.setId(empresaDTO.getId());
        empresa.setDepartamento(empresaDTO.getDepartamento());
        empresa.setNome(empresaDTO.getNome());
        empresa.setDivisao(empresaDTO.getDivisao());
        empresa.setFimJornada(empresaDTO.getFimJornada());
        empresa.setInicioJornada(empresaDTO.getInicioJornada());
        empresa.setNumFuncionario(empresaDTO.getNumFuncionario());
    }
}
