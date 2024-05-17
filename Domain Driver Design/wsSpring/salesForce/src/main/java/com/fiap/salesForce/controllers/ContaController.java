package com.fiap.salesForce.controllers;

import com.fiap.salesForce.dto.ContaResponseDTO;
import com.fiap.salesForce.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<ContaResponseDTO>> findAll() {
        return ResponseEntity.ok(contaService.findAll());
    }

}
