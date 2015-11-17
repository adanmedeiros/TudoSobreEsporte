package br.com.caelum.tudosobreesporte.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
	@Override
	public void init (FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			Connection connection = new ConnectionFactory().getConnection();

			request.setAttribute ("connection", connection);

			chain.doFilter (request, response);

			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}	
}