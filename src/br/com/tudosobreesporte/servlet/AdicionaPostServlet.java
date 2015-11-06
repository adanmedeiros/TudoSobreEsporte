package br.com.tudosobreesporte.servlet;

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

import br.com.tudosobreesporte.jdbc.dao.PostDao;
import br.com.tudosobreesporte.jdbc.posts.Post;

@SuppressWarnings("serial")
@WebServlet("/adicionaPost")
public class AdicionaPostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		PrintWriter out = resp.getWriter();

		String titulo = req.getParameter("titulo");
		String conteudo = req.getParameter("conteudo");
		String tags = req.getParameter("tags");

		Post post = new Post();
		post.setData(Calendar.getInstance());
		post.setTitulo(titulo);
		post.setConteudo(conteudo);
		post.setTags(tags);

		PostDao dao = new PostDao(connection);
		dao.adiciona(post);

		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}
}