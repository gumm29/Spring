package com.produto.demo;

import com.produto.demo.models.Produto;
import com.produto.demo.repository.ProdutoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProdutoRepositoryTest {

  @Autowired
  private ProdutoRepository repository;

  @Test
  public void findByIdTest(){
    int id = 18;
    Optional<Produto> produto = repository.findById(id);
    assertNotNull(produto);
    assertEquals(id, produto.get().getId());
  }
}
