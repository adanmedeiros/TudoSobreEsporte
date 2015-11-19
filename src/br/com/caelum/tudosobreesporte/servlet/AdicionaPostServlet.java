package br.com.caelum.tudosobreesporte.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.converter.PostConverter;
import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

@SuppressWarnings("serial")
@WebServlet("/adicionaPost")
public class AdicionaPostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) request.getAttribute("connection");

		Post post = new PostConverter().converte(request, response);

		PostDao postDao = new PostDao(connection);
		postDao.adiciona(post);

		response.sendRedirect("posts");
	}
}