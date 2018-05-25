package br.biblioteca.livros.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livro.util.FileSaver;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;

@Controller
public class LivroController {
	
	@Autowired //Anotação para injeção de dependências - CDI
	LivroService livroservice;
	
	//index
	@GetMapping("/")
		public String homein() {
		
		//return new ModelAndView("index");
		return "index";
	}	
	
	//create
	@GetMapping("livros/novo")
	public String createForm(@ModelAttribute Livro livro) {
		return "livros/formLivros";
	} 
	
	//save
	//@PostMapping(value = "/gravar")//(params = "formLivros")
	@RequestMapping(value="livros/gravar")
	public ModelAndView create(@RequestParam("capaUrl") MultipartFile capaUrl, @ModelAttribute @Valid Livro livro, BindingResult bindingResult, Model model) {
		
		//imagem
		if(capaUrl.getOriginalFilename().equals("")) {
			model.addAttribute("message", "A capa não pode ser vazia");
			return new ModelAndView("livros/novo");
		}else {
			if(capaUrl.getContentType().equals("image/jpeg")){
				String webPath = new FileSaver().write("uploaded-images",capaUrl);
				livro.setFoto(webPath);
			}else{
				model.addAttribute("message", "Arquivo em formato errado. Permitido apenas jpg");
				return new ModelAndView("livros/novo");
			}
		}
		
		//validação de bean
		if(bindingResult.hasErrors() || model.containsAttribute("capa")) {
			
			return new ModelAndView("livros/formLivros");
		}
		
		 livroservice.salvaLivro(livro);
	   	 return new ModelAndView("redirect:/livros/list");
	}
	
	//list
	@GetMapping("/livros/list")
	public ModelAndView livros() {
	
	List<Livro> livros = livroservice.listaLivros();
	
		return new ModelAndView("livros/livro", "livros", livros);
	}

	//Alterar
	@GetMapping("/livros/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		
		Livro livro = this.livroservice.BuscaLivroId(id);
		
		return new ModelAndView("livros/formLivros","livro",livro);
	}
	
	//Excluir
	@GetMapping("/livros/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		
	
		this.livroservice.excluirLivro(id);
			
		
		return new ModelAndView("redirect:/livros/list");
	}
	
}
