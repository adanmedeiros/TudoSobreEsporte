package br.com.caelum.tudosobreesporte.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;
import br.com.caelum.tudosobreesporte.model.Categoria;

public class RemoveCategoriaTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		CategoriaDao categoriaDao = new CategoriaDao(connection);

		List<Categoria> categorias = categoriaDao.getLista();

		for(Categoria categoria : categorias) {
			if(categoriaDao.remove (categoria.getId()) == true) {
				System.out.println("Categoria removida com sucesso!");
			} else {
				System.out.println("Categoria não existe ou possui post atrelado!");
			}
		}

		connection.close();
	}
}