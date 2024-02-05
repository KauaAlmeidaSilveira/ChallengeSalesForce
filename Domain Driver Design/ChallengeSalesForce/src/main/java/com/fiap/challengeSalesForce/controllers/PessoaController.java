package com.fiap.challengeSalesForce.controllers;

import com.fiap.challengeSalesForce.dto.PessoaComEnderecoDTO;
import com.fiap.challengeSalesForce.dto.PessoaDTO;
import com.fiap.challengeSalesForce.services.PessoaService;
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
    public ResponseEntity<List<?>> findAll(@RequestParam(name = "withAddress", defaultValue = "false") String pessoaComEndereco) {
        return ResponseEntity.ok(pessoaService.findAll(pessoaComEndereco, Object.class));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id, @RequestParam(name = "withAddress", defaultValue = "false") String pessoaComEndereco) {
        return ResponseEntity.ok(pessoaService.findById(id, pessoaComEndereco, Object.class));
    }

    @PostMapping
    public ResponseEntity<PessoaComEnderecoDTO> insert(@RequestBody PessoaComEnderecoDTO pessoa){
        pessoa = pessoaService.insert(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pessoa.getId())
                .toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

}