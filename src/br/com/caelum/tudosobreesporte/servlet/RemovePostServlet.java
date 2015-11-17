package br.com.caelum.tudosobreesporte.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

@SuppressWarnings("serial")
@WebServlet("/removePost")
public class RemovePostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");

		int id = Integer.parseInt(req.getParameter("id"));

		PostDao dao = new PostDao(connection);
		dao.remove(id);

		RequestDispatcher rd = req.getRequestDispatcher("/posts.jsp");
		rd.forward(req, resp);
	}
}