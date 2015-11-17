package br.com.caelum.tudosobreesporte.converter;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.model.Post;

public class CadastroPostConverter {
	public Post converte (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String titulo = req.getParameter("titulo");
		String conteudo = req.getParameter("conteudo");
		String tags = req.getParameter("tags");

		Post post = new Post(titulo, conteudo, tags);

		return post;
	}
}