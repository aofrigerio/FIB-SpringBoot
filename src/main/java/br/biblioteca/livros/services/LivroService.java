package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	AutorRepository autorRepository;
	
	//lista todos
	public List<Livro> listaLivros(){		
			return livroRepository.findAll();
	}
	
	//find by one
	public Livro BuscaLivroId(Long id) {
		return livroRepository.findOne(id);
	}
	
	//excluir
	public void excluirLivro(long id) {
		
		try {
			livroRepository.delete(id);
		} catch (Exception e) {
			return;
		}
		
		
	}
	
	//salvar
	public void salvaLivro(Livro livro) {
		
		Autor autor = autorRepository.findOne(2l);
		
		livro.setAutor(autor);
		livroRepository.save(livro);
	}
	
	
}
