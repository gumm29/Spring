package com.produto.demo.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="TB_PRODUTO")
public class Produto implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @NotNull @NotEmpty @Length(min = 3)
  private String nome;

  @NotNull
  private BigDecimal quantidade;

  @NotNull
  private BigDecimal valor;

  public long getId(){ return this.id; }
  public void setId(long id){ this.id = id; }

  public String getNome(){ return this.nome; }
  public void setNome(String nome){ this.nome = nome; }

  public BigDecimal getQuantidade(){ return this.quantidade; }
  public void setQuantidade(BigDecimal quantidade){ this.quantidade = quantidade; }

  public BigDecimal getValor(){ return this.valor; }
  public void setValor(BigDecimal valor){ this.valor = valor; }
}