package com.produto.demo.repository;

import java.util.Optional;

import com.produto.demo.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
