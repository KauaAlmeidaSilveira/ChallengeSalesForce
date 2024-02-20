package com.fiap.challengeSalesForce.controllers;

import com.fiap.challengeSalesForce.dto.PessoaAllAttributesDTO;
import com.fiap.challengeSalesForce.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<?>> findAll(@RequestParam(name = "withAllAttributes", defaultValue = "false") String withAllAttributes) {
        return ResponseEntity.ok(pessoaService.findAll(withAllAttributes, Object.class));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestParam(name = "withAllAttributes", defaultValue = "false") String withAllAttributes) {
        return ResponseEntity.ok(pessoaService.findById(id, withAllAttributes, Object.class));
    }

    @PostMapping
    public ResponseEntity<PessoaAllAttributesDTO> insert(@Valid @RequestBody PessoaAllAttributesDTO pessoa){
        pessoa = pessoaService.insert(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pessoa.getId())
                .toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

}
