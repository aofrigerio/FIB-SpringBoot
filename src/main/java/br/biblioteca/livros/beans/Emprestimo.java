package br.biblioteca.livros.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue
	private int id;
	
	private Date dataEmprestimo;
	
	private Date dataDevolucao;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Livro livro;
	

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataemprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataemprestimo(Date dataemprestimo) {
		this.dataEmprestimo = dataemprestimo;
	}
	
	public Date getDatadevolucao() {
		return dataDevolucao;
	}
	
	public void setDatadevolucao(Date datadevolucao) {
		this.dataDevolucao = datadevolucao;
	}
	

}
