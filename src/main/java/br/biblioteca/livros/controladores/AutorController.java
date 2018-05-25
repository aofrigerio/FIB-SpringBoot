package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.services.AutorService;

@Controller
public class AutorController {
	
	@Autowired
	AutorService autorservice;
	
	//list
	@GetMapping("/autores/list")
	public ModelAndView autores() {
		
		List<Autor> autor = autorservice.listaAutor();
		
		return new ModelAndView("autores/autores","autores", autor);
	}
	
	//new
	@GetMapping("autores/novo")
	public String createForm(@ModelAttribute Autor autor) {  	
		return "autores/formAutor";
	}
	
	//@PostMapping(params = "formAutor")
	@RequestMapping("autores/gravar")
	public ModelAndView create(Autor autor) {
			
		 autorservice.salvarAutor(autor);
	   	 return new ModelAndView("redirect:/autores/list");
	}
	
	


	
}
