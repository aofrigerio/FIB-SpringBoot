package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioservivces;
	
	@GetMapping("/usuarios")
	public ModelAndView autores() {
		
		List<Usuario> usuario = usuarioservivces.findAll();
		
		return new ModelAndView("usuarios/usuarios","usuarios", usuario);
	}
	
}
