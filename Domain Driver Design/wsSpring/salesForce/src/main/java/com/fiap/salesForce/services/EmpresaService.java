package com.fiap.salesForce.services;

import com.fiap.salesForce.dto.EmpresaDTO;
import com.fiap.salesForce.dto.Register.EmpresaRegisterDTO;
import com.fiap.salesForce.model.Empresa;
import com.fiap.salesForce.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    public List<EmpresaDTO> findAll() {
        return empresaRepository.findAll().stream().map(EmpresaDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public EmpresaDTO insert(EmpresaRegisterDTO body) {
        Empresa newEmpresa = new Empresa();
        newEmpresa.setNome(body.getNome());
        newEmpresa.setNumFuncionario(body.getNumFuncionario());
        empresaRepository.save(newEmpresa);
        return new EmpresaDTO(newEmpresa);
    }

}
