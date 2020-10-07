package com.produto.demo.exception;

public class FromError {

  private String campo;
  private String mensagem;

  public FromError(String campo, String mensagem) {
    this.campo = campo;
    this.mensagem = mensagem;
  }

  public String getCampo(){ return this.campo; }
  public String getMensagem() { return this.mensagem; }
}
