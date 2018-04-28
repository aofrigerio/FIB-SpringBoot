package br.biblioteca.livros.beans;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<Review> review = new ArrayList<>();
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
