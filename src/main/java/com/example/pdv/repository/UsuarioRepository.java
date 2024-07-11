package com.example.pdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pdv.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
