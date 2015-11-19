package br.com.caelum.tudosobreesporte.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;
import br.com.caelum.tudosobreesporte.model.Post;

public class RemovePostTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		PostDao postDao = new PostDao(connection);

		List<Post> posts = postDao.getLista();

		for(Post post : posts) {
			if(postDao.remove(post.getId()) == true) {
				System.out.println("Post removido com sucesso!");
			} else {
				System.out.println("Post não existe!");
			}
		}

		connection.close();
	}
}