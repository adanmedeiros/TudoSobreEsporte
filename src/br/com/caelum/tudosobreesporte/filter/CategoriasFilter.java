package br.com.caelum.tudosobreesporte.filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.tudosobreesporte.dao.CategoriaDao;
import br.com.caelum.tudosobreesporte.model.Categoria;

@WebFilter(filterName = "categorias")
public class CategoriasFilter implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Connection connection = (Connection) request.getAttribute("connection");

		CategoriaDao categoriaDao = new CategoriaDao(connection);
		List<Categoria> categorias = categoriaDao.getLista();

		request.setAttribute("categorias", categorias);

		chain.doFilter(request, response);
	}
}