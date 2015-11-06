package br.com.tudosobreesporte.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tudosobreesporte.jdbc.dao.PostsDao;
import br.com.tudosobreesporte.jdbc.posts.Posts;

@SuppressWarnings("serial")
@WebServlet("/removePost")
public class RemovePostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");

		int id = Integer.parseInt(req.getParameter("id"));

		Posts post = new Posts();
		post.setId(id);

		PostsDao dao = new PostsDao(connection);
		dao.remove(post.getId());

		RequestDispatcher rd = req.getRequestDispatcher("/posts.jsp");
		rd.forward(req, resp);
	}
}