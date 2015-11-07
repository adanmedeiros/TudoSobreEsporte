package br.com.tudosobreesporte.posts;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tudosobreesporte.jdbc.posts.Post;

public class CadastroPostConverter {
	public Post converte (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		String data = req.getParameter("data");
		String titulo = req.getParameter("titulo");
		String conteudo = req.getParameter("conteudo");
		String tags = req.getParameter("tags");

		Calendar dataPublicacao = Calendar.getInstance();

		try {
			data = sdf.format(Calendar.getInstance().getTime());
			dataPublicacao.setTime(sdf.parse(data));
		} catch (ParseException e) {
			resp.getWriter().println("Erro de conversão de data!");
			return null;
		}

		Post post = new Post();
		post.setData(dataPublicacao);
		post.setTitulo(titulo);
		post.setConteudo(conteudo);
		post.setTags(tags);

		return post;
	}
}