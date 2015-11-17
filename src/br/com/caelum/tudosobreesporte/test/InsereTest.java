package br.com.caelum.tudosobreesporte.test;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

public class InsereTest {
	public static void main(String[] args) {
		Post post = new Post("Titulo", "Conteudo", "Tag");

		Post post2 = new Post("Titulo2", "Conteudo2", "Tag2");

		Post post3 = new Post("Titulo3", "Conteudo3", "Tag3");

		PostDao dao = new PostDao();

		dao.adiciona(post);
		dao.adiciona(post2);
		dao.adiciona(post3);

		System.out.println("Gravado!");
	}
}