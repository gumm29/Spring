package com.produto.demo.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="TB_USER")
public class User implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String email;
  private String senha;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Perfil> perfis = new ArrayList<>();

  public Long getId() { return this.id; }
  public void setId(Long id) { this.id = id; }

  public String getNome() { return this.nome; }
  public void setNome(String nome) { this.nome = nome; }

  public String getEmail() { return this.email; }
  public void setEmail(String email) {  this.email = email; }

  public String getSenha() { return this.senha; }
  public void setSenha(String senha) { this.senha = senha; }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.perfis;
  }

  @Override
  public String getPassword() { return this.senha; }

  @Override
  public String getUsername() { return this.email; }

  @Override
  public boolean isAccountNonExpired() { return true; }

  @Override
  public boolean isAccountNonLocked() { return true; }

  @Override
  public boolean isCredentialsNonExpired() { return true; }

  @Override
  public boolean isEnabled() { return true; }
}
