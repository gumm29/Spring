package com.produto.demo.service;

import java.util.Optional;

import com.produto.demo.models.User;
import com.produto.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Autenticacao implements UserDetailsService {

  @Autowired
  private UsuarioRepository repository;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    Optional<User> usuario = repository.findByEmail(userName);
    if (usuario.isPresent()) return usuario.get();
    throw new UsernameNotFoundException("Usuario inexistente");
  }
  
}
