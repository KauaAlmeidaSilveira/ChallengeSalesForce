package com.fiap.salesForce.security;

import com.fiap.salesForce.model.Conta;
import com.fiap.salesForce.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ContaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Conta conta = this.repository.findByEmail(usuario).orElseThrow(() -> new UsernameNotFoundException("Conta not found"));
        return new org.springframework.security.core.userdetails.User(conta.getEmail(), conta.getSenha(), new ArrayList<>());
    }
}
