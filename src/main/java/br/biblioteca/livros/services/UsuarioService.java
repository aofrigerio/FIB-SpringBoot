package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.repository.UsuarioRepository;

public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuariorepository;
	
	
	public List<Usuario> findAll(){
		
		
		return usuariorepository.findAll();
	}

}
