package com.produto.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.produto.demo.models.User;
import com.produto.demo.repository.UsuarioRepository;
import com.produto.demo.service.TokenService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class FilterToken extends OncePerRequestFilter {

  private TokenService tokenService;
  private UsuarioRepository usuarioRepository;

  public FilterToken(TokenService tokenService, UsuarioRepository usuarioRepository) {
    this.tokenService = tokenService;
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String token = recuperarToken(request);
    boolean isValid = tokenService.tokenValido(token);
    System.out.println(isValid);
    if (isValid) {
      autenticaCliente(token);
    }
    filterChain.doFilter(request, response);
  }

  private void autenticaCliente(String token) {
    Long idUsuario = tokenService.getIdUsuario(token);
    User usuario = usuarioRepository.findById(idUsuario).get();
    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }

  private String recuperarToken(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    if (token == null || token.isEmpty() || !token.startsWith("Bearer ")){
      return null;
    } 
    return token.substring(7, token.length());
  }
}