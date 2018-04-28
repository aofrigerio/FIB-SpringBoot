package br.biblioteca.livros.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;

@Controller
public class LivroController {
	
	@Autowired //Anotação para injeção de dependências - CDI
	LivroService livroservice;
	
	//index
	@GetMapping("/")
		public ModelAndView home() {
		
		return new ModelAndView("index");
	}	
	
	//create
	@GetMapping("livros/novo")
	public String createForm(@ModelAttribute Livro livro) {
		return "livros/formLivros";
	} 
	
	@PostMapping(params = "formLivros")
	public ModelAndView create(Livro livro) {
			
		 livroservice.salvaLivro(livro);
	   	 return new ModelAndView("redirect:/livros");
	}
	
	//listar
	@GetMapping("/livros")
		public ModelAndView livros() {
		
		List<Livro> livros = livroservice.listaLivros();
		
		return new ModelAndView("livros/livro", "livros", livros);
	}
	
	

}
