package com.fiap.salesForce.repositories;

import com.fiap.salesForce.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
