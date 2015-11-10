package br.com.caelum.tudosobreesporte.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.tudosobreesporte.converter.CadastroPostConverter;
import br.com.caelum.tudosobreesporte.dao.PostDao;
import br.com.caelum.tudosobreesporte.model.Post;

@SuppressWarnings("serial")
@WebServlet("/adicionaPost")
public class AdicionaPostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");

		Post post = new CadastroPostConverter().converte(req, resp);

		PostDao dao = new PostDao(connection);
		dao.adiciona(post);

		RequestDispatcher rd = req.getRequestDispatcher("/posts.jsp");
		rd.forward(req, resp);
	}
}