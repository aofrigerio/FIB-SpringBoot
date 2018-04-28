package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Review;
import br.biblioteca.livros.repository.ReviewreRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewreRepository reviewrepository;
	
	public List<Review> findAll(){
		
		return reviewrepository.findAll();
	}
	
}
