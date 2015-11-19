package br.com.caelum.tudosobreesporte.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;
import br.com.caelum.tudosobreesporte.model.Post;

public class ListaPostsTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		PostDao postDao = new PostDao(connection);

		List<Post> posts = postDao.getLista();

		for(Post post : posts) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String dataFormatada = sdf.format(post.getData().getTime());

			System.out.println("ID: " + post.getId());
			System.out.println("Data: " + dataFormatada);
			System.out.println("Titulo: " + post.getTitulo());
			System.out.println("Conteudo: " + post.getConteudo());
			System.out.println("Categoria: " + post.getCategoria().getNome() + "\n");
		}

		connection.close();
	}
}