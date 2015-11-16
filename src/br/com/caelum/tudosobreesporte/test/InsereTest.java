package br.com.caelum.tudosobreesporte.test;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

public class InsereTest {
	public static void main(String[] args) {
		Post post = new Post();

		post.setTitulo("Titulo");
		post.setConteudo("Conteudo");
		post.setTags("Tag");

		Post post2 = new Post();

		post2.setTitulo("Titulo2");
		post2.setConteudo("Conteudo2");
		post2.setTags("Tag2");

		Post post3 = new Post();

		post3.setTitulo("Titulo3");
		post3.setConteudo("Conteudo3");
		post3.setTags("Tag3");

		PostDao dao = new PostDao();

		dao.adiciona(post);
		dao.adiciona(post2);
		dao.adiciona(post3);

		System.out.println("Gravado!");
	}
}