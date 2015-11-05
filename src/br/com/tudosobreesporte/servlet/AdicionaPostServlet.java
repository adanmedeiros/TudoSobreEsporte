package br.com.tudosobreesporte.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import br.com.tudosobreesporte.jdbc.dao.PostsDao;
import br.com.tudosobreesporte.jdbc.posts.Posts;

@SuppressWarnings("serial")
@WebServlet("/adicionaPost")
public class AdicionaPostServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String data = req.getParameter("data");
		String titulo = req.getParameter("titulo");
		String conteudo = req.getParameter("conteudo");
		String tags = req.getParameter("tags");

		Calendar dataPublicacao = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
			dataPublicacao = Calendar.getInstance();
			dataPublicacao.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversão de data");
			return;
		}

		Posts post = new Posts();
		post.setData(dataPublicacao);
		post.setTitulo(titulo);
		post.setConteudo(conteudo);
		post.setTags(tags);

		PostsDao dao = new PostsDao();
		dao.adiciona(post);

		RequestDispatcher rd = req.getRequestDispatcher("/postAdicionado.jsp");
		rd.forward(req, resp);
	}
}