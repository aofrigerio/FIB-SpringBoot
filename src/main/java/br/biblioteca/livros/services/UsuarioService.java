package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuariorepository;

	public List<Usuario> findAll(){
		
		return usuariorepository.findAll();
	}
	
	public void salvarUsuario(Usuario usuario) {
		
		usuariorepository.save(usuario);
	}

}
