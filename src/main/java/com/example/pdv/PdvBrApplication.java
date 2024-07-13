package com.example.pdv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pdv.enums.EnumTipoPagamento;
import com.example.pdv.model.Venda;

@SpringBootApplication
@RestController
public class PdvBrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdvBrApplication.class, args);
	}

	@GetMapping("/")
	public ModelAndView nomeUsuario() {
        List<Venda> vendas = new ArrayList<>();
    
        Venda vAux;
        for (int i = 0; i < 5; i++) {
            vAux = new Venda();
            vAux.setCodVenda(Long.valueOf(i+1));
            vAux.setDataVenda(new Date());
            vAux.setCobrado(10.0);
            vAux.setTroco(12.0);
            vAux.setPago(100.0);
            if (i % 2 == 0) {
                vAux.setTipoPagamento(EnumTipoPagamento.DN);
            } else {
                vAux.setTipoPagamento(EnumTipoPagamento.CD);
            }
            vendas.add(vAux);
        }
                
		ModelAndView mv = new ModelAndView("index.html");
                
                mv.addObject("vendas", vendas);
                
		return mv;
	}

}
