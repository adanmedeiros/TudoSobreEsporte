package br.com.tudosobreesporte.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.tudosobreesporte.jdbc.dao.PostsDao;
import br.com.tudosobreesporte.jdbc.posts.Posts;

public class ListaTest {
	public static void main(String[] args) {
		PostsDao dao = new PostsDao();

		List<Posts> posts = dao.getLista();

		for (Posts post : posts) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String dataFormatada = sdf.format(post.getData().getTime());

			System.out.println("ID: " + post.getId());
			System.out.println("Data: " + dataFormatada);
			System.out.println("Titulo: " + post.getTitulo());
			System.out.println("Conteudo: " + post.getConteudo());
			System.out.println("Tags: " + post.getTags() + "\n");
		}
	}
}