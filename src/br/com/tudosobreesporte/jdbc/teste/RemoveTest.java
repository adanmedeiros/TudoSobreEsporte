package br.com.tudosobreesporte.jdbc.teste;

import java.util.List;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

public class RemoveTest {
	public static void main(String[] args) {
		PostDao dao = new PostDao();

		List<Post> posts = dao.getLista();

		for (Post post : posts) {
			dao.remove(post.getId());
		}
	}
}