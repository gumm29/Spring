package com.produto.demo.models;

public class Token {
  
  private String token;
  private String tipo;

  public Token(String token, String tipo){
    this.token= token;
    this.tipo = tipo;
  }

  public String getToken() { return this.token; }
  public void setToken(String token) { this.token = token; }

  public String getTipo() {return this.tipo; }
  public void setTipo(String tipo) { this.tipo = tipo; }
}
