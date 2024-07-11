package com.example.pdv.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pdv.model.Usuario;
import com.example.pdv.repository.UsuarioRepository;

@RestController
public class UsuarioController {
    
    private final UsuarioRepository repository;
    

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/usuarios")
    public ModelAndView listaUsuarios() {
        ModelAndView mv = new ModelAndView("usuario");
        return mv;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario listaUsuarios(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/usuarios")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PutMapping("/usuarios/{id}")
    Usuario atualizar(@RequestBody Usuario novoUsuario, @PathVariable Long id) {
        
        return repository.findById(id)
            .map(usuario -> {
                usuario.setNome(novoUsuario.getNome());
                usuario.setCpf(novoUsuario.getCpf());
                return repository.save(usuario);
            })
            .orElseGet(() -> {
                return repository.save(novoUsuario);
            });
    }

    @DeleteMapping("/usuarios/{id}")
    void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
