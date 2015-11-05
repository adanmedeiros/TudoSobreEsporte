package br.com.tudosobreesporte.jdbc.teste;

import java.util.List;

import br.com.tudosobreesporte.jdbc.dao.PostsDao;
import br.com.tudosobreesporte.jdbc.posts.Posts;

public class RemoveTest {
	public static void main(String[] args) {
		PostsDao dao = new PostsDao();

		List<Posts> posts = dao.getLista();

		for (Posts post : posts) {
			dao.remove(post.getId());
		}
	}
}