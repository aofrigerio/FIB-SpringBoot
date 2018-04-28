package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.biblioteca.livros.beans.Review;
import br.biblioteca.livros.services.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	ReviewService reviewservice;
	
	@GetMapping("/reviews")
	public ModelAndView autores() {
		
		List<Review> review = reviewservice.findAll();
		
		return new ModelAndView("reviewservice/reviewservice","reviewservice", review);
	}
}
