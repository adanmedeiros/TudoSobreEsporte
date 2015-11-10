package br.com.caelum.tudosobreesporte.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");

		PrintWriter out = resp.getWriter();

		String nome = req.getParameter("categoria");

		Categoria categoria = new Categoria();
		categoria.setNome(nome);

		CategoriaDao dao = new CategoriaDao(connection);
		dao.adiciona(categoria);

		RequestDispatcher rd = req.getRequestDispatcher("/categorias.jsp");
		rd.forward(req, resp);
	}
}