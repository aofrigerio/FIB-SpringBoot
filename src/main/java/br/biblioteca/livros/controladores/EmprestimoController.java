package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.biblioteca.livros.beans.Emprestimo;
import br.biblioteca.livros.services.EmprestimoService;

@Controller
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoservice;
	
	@GetMapping("/emprestimos")
	public ModelAndView autores() {
		
		List<Emprestimo> emprestimos = emprestimoservice.findAll();
		
		return new ModelAndView("emprestimos/emprestimos","emprestimos", emprestimos);
	}
	
}
