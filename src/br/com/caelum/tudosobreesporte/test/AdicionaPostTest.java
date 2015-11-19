package br.com.caelum.tudosobreesporte.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;
import br.com.caelum.tudosobreesporte.model.Categoria;
import br.com.caelum.tudosobreesporte.model.Post;

public class AdicionaPostTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		CategoriaDao categoriaDao = new CategoriaDao(connection);

		List<Categoria> categorias = categoriaDao.getLista();

		Categoria categoria1 = categorias.get(0);
		Categoria categoria2 = categorias.get(1);

		Post post1 = new Post("Titulo1", "Conteudo1", categoria1);
		Post post2 = new Post("Titulo2", "Conteudo2", categoria1);
		Post post3 = new Post("Titulo3", "Conteudo3", categoria2);
		Post post4 = new Post("Titulo4", "Conteudo4", categoria2);

		PostDao postDao = new PostDao(connection);

		if(postDao.adiciona(post1) == true) {
			System.out.println("Post adicionado com sucesso!");
		} else {
			System.out.println("Post já existe!");
		}

		if(postDao.adiciona(post2) == true) {
			System.out.println("Post adicionado com sucesso!");
		} else {
			System.out.println("Post já existe!");
		}

		if(postDao.adiciona(post3) == true) {
			System.out.println("Post adicionado com sucesso!");
		} else {
			System.out.println("Post já existe!");
		}

		if(postDao.adiciona(post4) == true) {
			System.out.println("Post adicionado com sucesso!");
		} else {
			System.out.println("Post já existe!");
		}

		if(postDao.adiciona(post1) == true) {
			System.out.println("Post adicionado com sucesso!");
		} else {
			System.out.println("Post já existe!");
		}

		if(postDao.adiciona(post2) == true) {
			System.out.println("Post adicionado com sucesso!");
		} else {
			System.out.println("Post já existe!");
		}

		if(postDao.adiciona(post3) == true) {
			System.out.println("Post adicionado com sucesso!");
		} else {
			System.out.println("Post já existe!");
		}

		if(postDao.adiciona(post4) == true) {
			System.out.println("Post adicionado com sucesso!");
		} else {
			System.out.println("Post já existe!");
		}

		connection.close();
	}
}