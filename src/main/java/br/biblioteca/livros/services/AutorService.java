package br.biblioteca.livros.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;
	
	public List<Autor> listaAutor(){
		return autorRepository.findAll();
	}
	
	public void salvarAutor(Autor autor) {
		autorRepository.save(autor);
	}
	
	public void deletarAutor(Autor autor) {
		autorRepository.delete(autor);
	}
}
