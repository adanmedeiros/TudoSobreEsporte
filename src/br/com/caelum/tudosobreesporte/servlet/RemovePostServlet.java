package br.com.caelum.tudosobreesporte.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.dao.PostDao;

@SuppressWarnings("serial")
@WebServlet("/removePost")
public class RemovePostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) request.getAttribute("connection");

		int id = Integer.parseInt(request.getParameter("id"));

		PostDao dao = new PostDao(connection);
		dao.remove(id);

		response.sendRedirect("posts");
	}
}