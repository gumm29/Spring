package com.produto.demo.controller;

import javax.validation.Valid;

import com.produto.demo.models.Login;
import com.produto.demo.models.Token;
import com.produto.demo.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController{

  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity<?> autenticar(@RequestBody @Valid Login login){
    UsernamePasswordAuthenticationToken dadosLogin = login.covert();
    try {
      Authentication authentication = authManager.authenticate(dadosLogin);
      String token = tokenService.gerarToken(authentication);
      System.out.println(token);
      return ResponseEntity.ok(new Token(token, "Bearer"));
    } catch (AuthenticationException e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
