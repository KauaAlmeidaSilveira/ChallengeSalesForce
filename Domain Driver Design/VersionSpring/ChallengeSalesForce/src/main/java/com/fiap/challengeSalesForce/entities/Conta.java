package com.fiap.challengeSalesForce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiap.challengeSalesForce.entities.enums.AccountStatus;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_conta")
public class Conta implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    @Column(unique = true)
    private String email;
    private String password;
    private AccountStatus status;
    @Column(columnDefinition = "DATE")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataRegistro;
    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime ultimoAcesso;

    @OneToOne
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(name = "tb_conta_role",
            joinColumns = @JoinColumn(name = "conta_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Conta() {
    }

    public Conta(Long id, String usuario, String email, String password, AccountStatus status, LocalDate dataRegistro, LocalDateTime ultimoAcesso, Pessoa pessoa) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.status = status;
        this.dataRegistro = dataRegistro;
        this.ultimoAcesso = ultimoAcesso;
        this.pessoa = pessoa;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasRole(String roleName) {
        for (Role role : roles) {
            if (role.getAuthority().equals(roleName)) {
                return true;
            }
        }
        return false;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        return Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
