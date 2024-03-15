package com.fiap.challengeSalesForce.services;

import com.fiap.challengeSalesForce.dto.ContaDTO;
import com.fiap.challengeSalesForce.entities.Conta;
import com.fiap.challengeSalesForce.entities.Role;
import com.fiap.challengeSalesForce.entities.enums.AccountStatus;
import com.fiap.challengeSalesForce.projections.UserDetailsProjection;
import com.fiap.challengeSalesForce.repositories.ContaRepository;
import com.fiap.challengeSalesForce.repositories.PessoaRepository;
import com.fiap.challengeSalesForce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContaService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ContaRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<ContaDTO> findAll() {
        return repository.findAll().stream().map(ContaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ContaDTO findById(Long id) {
        Conta conta = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado !!"));
        conta.setUltimoAcesso(LocalDateTime.now());
        return new ContaDTO(repository.save(conta));
    }

    @Transactional
    public ContaDTO insert(ContaDTO contaDTO) {
        Conta conta = new Conta();
        copyDtoToEntity(contaDTO, conta);
        conta.setPassword(passwordEncoder.encode(contaDTO.getSenha()));
        conta = repository.save(conta);
        return new ContaDTO(conta);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public ContaDTO update(Long id, ContaDTO contaDTO) {
        Conta conta = repository.findById(id).get();
        updateDtoToEntity(contaDTO, conta);
        repository.save(conta);
        return new ContaDTO(conta);
    }

    private void copyDtoToEntity(ContaDTO contaDTO, Conta conta) {
        conta.setId(contaDTO.getId());
        conta.setUsuario(contaDTO.getUsuario());
        conta.setEmail(contaDTO.getEmail());
        conta.setPassword(contaDTO.getSenha());
        conta.setStatus(AccountStatus.ATIVO);
        conta.setDataRegistro(LocalDate.now());
        conta.setUltimoAcesso(LocalDateTime.now());
        conta.setPessoa(pessoaRepository.getReferenceById(contaDTO.getPessoaId()));
    }

    private void updateDtoToEntity(ContaDTO contaDTO, Conta conta) {
        if (contaDTO.getUsuario() != null) {
            conta.setUsuario(contaDTO.getUsuario());
        }
        if (contaDTO.getEmail() != null) {
            conta.setEmail(contaDTO.getEmail());
        }
        if (contaDTO.getSenha() != null) {
            conta.setPassword(contaDTO.getSenha());
        }
        conta.setUltimoAcesso(LocalDateTime.now());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("Email not found");
        }
        Conta conta = new Conta();
        conta.setEmail(result.get(0).getUsername());
        conta.setPassword(result.get(0).getPassword());

        for (UserDetailsProjection projection : result){
            conta.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return conta;
    }
}
