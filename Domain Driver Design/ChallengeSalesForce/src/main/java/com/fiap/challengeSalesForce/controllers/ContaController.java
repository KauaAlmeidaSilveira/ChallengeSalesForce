package com.fiap.challengeSalesForce.controllers;

import com.fiap.challengeSalesForce.dto.ContaDTO;
import com.fiap.challengeSalesForce.services.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity<List<ContaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ContaDTO> insert(@Valid @RequestBody ContaDTO contaDTO){
        ContaDTO result = service.insert(contaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(result);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> update(@PathVariable Long id, @Valid @RequestBody ContaDTO contaDTO){
        return ResponseEntity.ok(service.update(id, contaDTO));
    }
}
