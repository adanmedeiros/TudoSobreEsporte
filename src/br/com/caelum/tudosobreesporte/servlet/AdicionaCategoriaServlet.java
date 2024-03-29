package br.com.caelum.tudosobreesporte.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.model.Categoria;

@SuppressWarnings("serial")
@WebServlet("/adicionaCategoria")
public class AdicionaCategoriaServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) request.getAttribute("connection");

		String nome = request.getParameter("categoria");

		Categoria categoria = new Categoria(nome);

		CategoriaDao categoriaDao = new CategoriaDao(connection);
		categoriaDao.adiciona(categoria);

		response.sendRedirect("categorias");
	}
}