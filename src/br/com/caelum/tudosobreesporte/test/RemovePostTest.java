package br.com.caelum.tudosobreesporte.test;

import java.util.List;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

public class RemovePostTest {
	public static void main (String[] args) {
		PostDao postDao = new PostDao();

		List<Post> posts = postDao.getLista();

		for (Post post : posts) {
			if (postDao.remove(post.getId()) == true) {
				System.out.println ("Post removido com sucesso!");
			} else {
				System.out.println ("Post não existe!");
			}
		}
	}
}