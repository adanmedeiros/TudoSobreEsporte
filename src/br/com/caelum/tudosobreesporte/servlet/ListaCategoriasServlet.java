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

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.model.Categoria;

@SuppressWarnings("serial")
@WebServlet("/categorias")
public class ListaCategoriasServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) request.getAttribute("connection");

		CategoriaDao categoriaDao = new CategoriaDao(connection);
		List<Categoria> categorias = categoriaDao.getLista();

		request.setAttribute("categorias", categorias);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/categorias.jsp");
		rd.forward(request, response);
	}
}