package com.example.pdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pdv.model.Usuario;

@SpringBootApplication
@RestController
public class PdvBrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdvBrApplication.class, args);
	}

	@GetMapping("/")
	public ModelAndView nomeUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Danilo Henrique Barbosa Pires");
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("usuario", usuario);

		return mv;
	}

}
