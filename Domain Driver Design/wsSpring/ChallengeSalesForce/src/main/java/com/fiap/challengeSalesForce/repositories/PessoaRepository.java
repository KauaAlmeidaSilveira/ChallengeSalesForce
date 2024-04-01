package com.fiap.challengeSalesForce.repositories;

import com.fiap.challengeSalesForce.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
