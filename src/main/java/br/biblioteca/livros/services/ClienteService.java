package br.biblioteca.livros.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Cliente;
import br.biblioteca.livros.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienterepository;
	
	public List<Cliente> findAll(){
		
		return clienterepository.findAll();
	}
	
}
