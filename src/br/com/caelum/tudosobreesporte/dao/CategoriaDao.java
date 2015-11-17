package br.com.caelum.tudosobreesporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;
import br.com.caelum.tudosobreesporte.model.Categoria;

public class CategoriaDao {
	private Connection connection;

	public CategoriaDao (Connection connection) {
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
			PreparedStatement stmt = connection.prepareStatement("select * from posts where tags = " + nome);
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return;
			}

			stmt = connection.prepareStatement ("delete from categorias where categoria = " + nome);

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

				categoria.setNome (rs.getString("categoria"));

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