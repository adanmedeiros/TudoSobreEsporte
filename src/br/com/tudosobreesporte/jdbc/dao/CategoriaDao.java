package br.com.tudosobreesporte.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.tudosobreesporte.jdbc.ConnectionFactory;
import br.com.tudosobreesporte.jdbc.modelo.Categoria;
import br.com.tudosobreesporte.jdbc.posts.Post;

public class CategoriaDao {
	private Connection connection;

	public CategoriaDao(Connection connection) {
		this.connection = connection;
	}

	public CategoriaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona (Categoria categoria) {
		String sql = "insert into categorias " + "(categoria)" + " values (?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString (1, categoria.getNome());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	public void remove (String nome) {
		try {
			PreparedStatement stmt = connection.prepareStatement ("delete from categorias where categoria=?");

			stmt.setString (1, nome);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	public List<Categoria> getLista() {
		try {
			List<Categoria> categorias = new ArrayList<Categoria>();

			PreparedStatement stmt = this.connection.prepareStatement ("select * from categorias");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Categoria categoria = new Categoria();

				categoria.setNome (rs.getString ("categoria"));

				categorias.add (categoria);
			}

			rs.close();
			stmt.close();

			return categorias;
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
}