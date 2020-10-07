package com.produto.demo.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.produto.demo.models.Produto;
import com.produto.demo.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping
public class ProdutoResource {

  @Autowired
  ProdutoRepository produtoRepository;

  @GetMapping
  public String hello(){
    return "ola";
  }

  @GetMapping("/produtos")
  public Page<Produto> listaProdutos(
    @PageableDefault(sort="id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
    return produtoRepository.findAll(paginacao);
  }

  @GetMapping("/produto/{id}")
  public ResponseEntity<?> listaProdutoUnico(@PathVariable long id) {
    Optional<Produto> selecionado = produtoRepository.findById(id);
    if (selecionado.isPresent()) return ResponseEntity.ok(selecionado);
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/produto")
  public ResponseEntity<Produto> salvaProduto(@RequestBody @Valid Produto produto, UriComponentsBuilder uriBuilder){
    produtoRepository.save(produto);
    URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produtoRepository.count()+1).toUri();
    return  ResponseEntity.created(uri).body(produto);
  }

  @PutMapping("/produto/{id}")
  @Transactional
  public ResponseEntity<?> updateProduto(@PathVariable long id, @RequestBody @Valid Produto produto){
    Optional<Produto> selecionado = produtoRepository.findById(id);
    if (selecionado.isPresent()) {
      selecionado.get().setNome(produto.getNome());
      selecionado.get().setQuantidade(produto.getQuantidade());
      selecionado.get().setValor(produto.getValor());
      return ResponseEntity.ok(selecionado);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/produto/{id}")
  @Transactional
  public ResponseEntity<?> deletaProduto(@PathVariable long id){
    Optional<Produto> selecionado = produtoRepository.findById(id);
    if(selecionado.isPresent()){
      produtoRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
