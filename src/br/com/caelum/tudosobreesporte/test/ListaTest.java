package br.com.caelum.tudosobreesporte.test;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

public class ListaTest {
	public static void main(String[] args) {
		PostDao dao = new PostDao();

		List<Post> posts = dao.getLista();

		for (Post post : posts) {
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