package br.com.tudosobreesporte.jdbc.teste;

import java.sql.Connection;

import br.com.tudosobreesporte.jdbc.dao.CategoriaDao;
import br.com.tudosobreesporte.jdbc.modelo.Categoria;

public class InsereCategoriaTest {
	public static void main(String[] args) {
		Categoria categoria = new Categoria();

		categoria.setNome("Skate");

		Categoria categoria2 = new Categoria();

		categoria2.setNome("Snowboard");

		CategoriaDao dao = new CategoriaDao();

		dao.adiciona(categoria);
		dao.adiciona(categoria2);

		System.out.println("Gravado!");
	}
}