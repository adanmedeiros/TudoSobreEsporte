package br.com.caelum.tudosobreesporte.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;
import br.com.caelum.tudosobreesporte.model.Categoria;

public class ListaCategoriasTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		CategoriaDao categoriaDao = new CategoriaDao(connection);

		List<Categoria> categorias = categoriaDao.getLista();

		for(Categoria categoria : categorias) {
			System.out.println(categoria.getNome());
		}

		connection.close();
	}
}