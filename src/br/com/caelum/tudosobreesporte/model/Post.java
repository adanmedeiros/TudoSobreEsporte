package br.com.caelum.tudosobreesporte.model;

import java.util.Calendar;

public class Post {
	private int id;
	private Calendar data = Calendar.getInstance();
	private String titulo;
	private String conteudo;
	private String tags;


	public Post(String titulo, String conteudo, String tags) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
}