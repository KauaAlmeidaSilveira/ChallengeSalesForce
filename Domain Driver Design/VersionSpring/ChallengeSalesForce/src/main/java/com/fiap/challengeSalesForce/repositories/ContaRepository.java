package com.fiap.challengeSalesForce.repositories;

import com.fiap.challengeSalesForce.entities.Conta;
import com.fiap.challengeSalesForce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query(nativeQuery = true, value = """
            	SELECT tb_conta.email AS username, tb_conta.password, tb_role.id AS roleId, tb_role.authority
            	FROM tb_conta
            	INNER JOIN tb_conta_role ON tb_conta.id = tb_conta_role.conta_id
            	INNER JOIN tb_role ON tb_role.id = tb_conta_role.role_id
            	WHERE tb_conta.email = :email
            """) // Select para evitar o lazy loading do JPA.
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

}
