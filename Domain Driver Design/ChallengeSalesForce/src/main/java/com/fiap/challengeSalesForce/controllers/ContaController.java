package com.fiap.challengeSalesForce.controllers;

import com.fiap.challengeSalesForce.dto.ContaDTO;
import com.fiap.challengeSalesForce.entities.Conta;
import com.fiap.challengeSalesForce.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping
    public List<ContaDTO> getTest(){
        return service.getTest();
    }

}
