package br.com.caelum.tudosobreesporte.test;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

public class ListaPostsTest {
	public static void main(String[] args) {
		PostDao postDao = new PostDao();

		List<Post> posts = postDao.getLista();

		for (Post post : posts) {
			SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
			String dataFormatada = sdf.format (post.getData().getTime());

			System.out.println ("ID: " + post.getId());
			System.out.println ("Data: " + dataFormatada);
			System.out.println ("Titulo: " + post.getTitulo());
			System.out.println ("Conteudo: " + post.getConteudo());
			System.out.println ("Categoria: " + post.getCategoria().getNome() + "\n");
		}
	}
}