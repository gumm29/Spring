package com.produto.demo.models;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Login {

  private String email;
  private String senha;

  public String getEmail(){ return email; }
  public void email(String email) { this.email = email; }

  public String getSenha(){ return senha; }
  public void senha(String senha) { this.senha = senha; }

  public UsernamePasswordAuthenticationToken covert() {
    return new UsernamePasswordAuthenticationToken(email, senha);
  }
}