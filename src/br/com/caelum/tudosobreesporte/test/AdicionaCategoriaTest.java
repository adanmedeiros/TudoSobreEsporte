package br.com.caelum.tudosobreesporte.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;
import br.com.caelum.tudosobreesporte.model.Categoria;

public class AdicionaCategoriaTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		Categoria categoria = new Categoria("Futebol");
		Categoria categoria2 = new Categoria("Basquete");

		CategoriaDao categoriaDao = new CategoriaDao(connection);

		if(categoriaDao.adiciona(categoria) == true) {
			System.out.println("Categoria adicionada com sucesso!");
		} else {
			System.out.println("Categoria já existe!");
		}

		if(categoriaDao.adiciona(categoria2) == true) {
			System.out.println("Categoria adicionada com sucesso!");
		} else {
			System.out.println("Categoria já existe!");
		}

		connection.close();
	}
}