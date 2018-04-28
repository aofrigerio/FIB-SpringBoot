package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.services.AutorService;

@Controller
public class AutorController {
	
	@Autowired
	AutorService autorservice;

	@GetMapping("/autores")
	public ModelAndView autores() {
		
		List<Autor> autor = autorservice.listaAutor();
		
		return new ModelAndView("autores/autores","autores", autor);
	}
	
	
}
