package br.com.caelum.tudosobreesporte.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

@SuppressWarnings("serial")
@WebServlet("")
public class ListaPostsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) request.getAttribute("connection");

		PostDao postDao = new PostDao(connection);
		List<Post> posts = postDao.getLista();

		request.setAttribute("posts", posts);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/index.jsp");
		rd.forward(request, response);
	}
}