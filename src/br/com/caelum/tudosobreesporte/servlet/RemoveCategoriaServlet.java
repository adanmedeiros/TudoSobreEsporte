package br.com.caelum.tudosobreesporte.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;

@SuppressWarnings("serial")
@WebServlet("/removeCategoria")
public class RemoveCategoriaServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) request.getAttribute("connection");


		CategoriaDao categoriaDao = new CategoriaDao(connection);
		categoriaDao.remove(Integer.parseInt(request.getParameter("id")));

		response.sendRedirect("categorias");
	}
}