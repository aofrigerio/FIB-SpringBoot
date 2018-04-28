package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.biblioteca.livros.beans.Emprestimo;
import br.biblioteca.livros.repository.EmprestimoRepository;

public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimorepository;
	
	public List<Emprestimo> findAll(){
			
		return emprestimorepository.findAll();
	}
	
}
