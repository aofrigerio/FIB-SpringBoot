package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService usuarioServivces;
	
	@GetMapping("/usuarios/list")
	public ModelAndView autores() {
		
		List<Usuario> usuario = usuarioServivces.findAll();
		
		return new ModelAndView("usuarios/usuarios","usuarios", usuario);
	}
	
	//Novo
	@GetMapping("/usuarios/novo")
	public String createUsuario(@ModelAttribute Usuario usuario) {
		return "usuarios/formUsuarios";
	}
	
	//@PostMapping(params="formUsuarios")
	@RequestMapping("usuarios/gravar")
	public ModelAndView createUsuarios(Usuario usuario) {
		
		usuarioServivces.salvarUsuario(usuario);
		
	   	return new ModelAndView("redirect:/usuarios");
	}
	
}
