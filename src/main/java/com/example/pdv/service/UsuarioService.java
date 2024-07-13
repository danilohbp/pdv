package com.example.pdv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdv.model.Usuario;
import com.example.pdv.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario inserir(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {
        return repository.findById(usuario.getId())
            .map(u -> {
                u.setNome(usuario.getNome());
                u.setCpf(usuario.getCpf());
                return repository.save(u);
            })
            .orElseGet(() -> {
                return repository.save(usuario);
            });
    }

    public List<Usuario> buscar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deletar(Usuario usuario) {
        repository.delete(usuario);
    }
}
