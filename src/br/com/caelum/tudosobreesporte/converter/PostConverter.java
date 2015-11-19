package br.com.caelum.tudosobreesporte.converter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.model.Categoria;
import br.com.caelum.tudosobreesporte.model.Post;

public class PostConverter {
	public Post converte(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String titulo = request.getParameter("titulo");
		String conteudo = request.getParameter("conteudo");

		CategoriaDao categoriaDao = new CategoriaDao((Connection) request.getAttribute("connection"));
		Categoria categoria = categoriaDao.getCategoria(Integer.parseInt(request.getParameter("categoriaId")));

		Post post = new Post(titulo, conteudo, categoria);

		return post;
	}
}