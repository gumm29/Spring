package com.produto.demo.repository;

import java.util.Optional;

import com.produto.demo.models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
  Optional<Produto> findById(long id);
}