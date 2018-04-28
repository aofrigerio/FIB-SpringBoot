package br.biblioteca.livros.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;

@Controller
public class LivroController {
	
	@Autowired //Anotação para injeção de dependências - CDI
	LivroService livroservice;
	
	@GetMapping("/")
		public ModelAndView home() {
		
		return new ModelAndView("index");
	}	
	
	@GetMapping("/livros")
		public ModelAndView livros() {
		
		List<Livro> livros = livroservice.listaLivros();
		/*
		for (Livro livro : livros) {
			System.out.println(livro.getNome());			
		}
		*/	
		
		return new ModelAndView("livros/livro", "livros", livros);
	}

}
