package com.produto.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="TB_USER_PERFIL")
public class Perfil implements GrantedAuthority{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nome;


  public long getId() { return this.id; }
  public void setId(long id) { this.id = id; }

  public String getNome() { return this.nome; }
  public void setNome(String nome) { this.nome = nome; }

  @Override
  public String getAuthority() {
    return nome;
  }
}
