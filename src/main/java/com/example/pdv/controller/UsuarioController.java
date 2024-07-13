package com.example.pdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pdv.model.Usuario;
import com.example.pdv.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ModelAndView listaUsuarios() {
        
        ModelAndView mv = new ModelAndView("usuario");
        
        mv.addObject("usuarios", usuarioService.buscar());

        return mv;
    }

    @GetMapping("/usuarios/{id}")
    public ModelAndView listaUsuarios(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("usuario");
        
        mv.addObject("usuarios", usuarioService.buscarPorId(id));

        return mv;
    }

    @PostMapping("/usuarios")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.inserir(usuario);
    }

    @PutMapping("/usuarios/{id}")
    Usuario atualizar(@RequestBody Usuario novoUsuario, @PathVariable Long id) {
        novoUsuario.setId(id);

        return usuarioService.atualizar(novoUsuario);
    }

    @DeleteMapping("/usuarios/{id}")
    void deletar(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);

        usuarioService.deletar(usuario);
    }
}
