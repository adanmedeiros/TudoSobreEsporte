package br.com.caelum.tudosobreesporte.model;

public class Categoria {
	private Integer id;
	private String nome;

	// Construtor!
	public Categoria (String nome) {
		this.nome = nome;
	}

	// Getters & Setters!
	public Integer getId() {
		return id;
	}

	public void setId (Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome (String nome) {
		this.nome = nome;
	}
}