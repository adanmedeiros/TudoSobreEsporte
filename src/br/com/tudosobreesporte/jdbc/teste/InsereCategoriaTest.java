package br.com.tudosobreesporte.jdbc.teste;

import java.sql.Connection;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.model.Categoria;

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