package br.com.caelum.tudosobreesporte.model;

import java.util.Calendar;

public class Post {
	private Integer id;
	private String titulo;
	private String conteudo;
	private Categoria categoria;
	private Calendar data = Calendar.getInstance();

	// Construtor.
	public Post(String titulo, String conteudo, Categoria categoria) {
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.setCategoria(categoria);
	}

	// Getters & Setters.
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
}