package br.com.tudosobreesporte.jdbc.teste;

import java.util.Calendar;

import br.com.tudosobreesporte.jdbc.dao.PostsDao;
import br.com.tudosobreesporte.jdbc.posts.Posts;

public class InsereTest {
	public static void main(String[] args) {
		Posts post = new Posts();

		post.setData(Calendar.getInstance());
		System.out.println(Calendar.getInstance().getTime());
		post.setTitulo("Titulo");
		post.setConteudo("Conteudo");
		post.setTags("Tag");

		Posts post2 = new Posts();

		post2.setData(Calendar.getInstance());
		post2.setTitulo("Titulo2");
		post2.setConteudo("Conteudo2");
		post2.setTags("Tag2");

		Posts post3 = new Posts();

		post3.setData(Calendar.getInstance());
		post3.setTitulo("Titulo3");
		post3.setConteudo("Conteudo3");
		post3.setTags("Tag3");

		PostsDao dao = new PostsDao();

		dao.adiciona(post);
		dao.adiciona(post2);
		dao.adiciona(post3);

		System.out.println("Gravado!");
	}
}