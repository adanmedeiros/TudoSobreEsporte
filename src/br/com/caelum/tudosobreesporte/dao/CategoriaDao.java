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

	// Construtores!
	public CategoriaDao (Connection connection) {
		this.connection = connection;
	}

	public CategoriaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Método para adicionar a categoria ao banco de dados!
	public boolean adiciona (Categoria categoria) {
		// Verifica se a categoria existe, se existir, não faz nada e retorna falso.
		try {
			PreparedStatement stmt = this.connection.prepareStatement ("select * from categorias where nome = ?");
			stmt.setString (1, categoria.getNome());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rs.close();
				stmt.close();

				return false;
			} else {
				// Se a categoria não existir , ela é criada e adicionada ao banco de dados.
				String sql = "insert into categorias " + "(nome)" + " values (?)";
	
				stmt = this.connection.prepareStatement (sql);
	
				stmt.setString (1, categoria.getNome());
	
				stmt.execute();
				stmt.close();
	
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	// Método para remoção da categoria do banco de dados!
	public boolean remove (Integer id) {
		// Verifica se possui algum post atrelado, se existir, não faz nada e retorna falso.
		try {
			PreparedStatement stmt = this.connection.prepareStatement ("select * from posts where categoria = ?");
			stmt.setInt (1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rs.close();
				stmt.close();

				return false;
			} else {
				// Se não possui post atrelado e a categoria existir, ela é removida do banco de dados.
				stmt = this.connection.prepareStatement ("delete * from categorias where id = ?");
				stmt.setInt(1, id);
	
				stmt.execute();
				stmt.close();
	
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	// Método para listar todas as categorias do banco de dados!
	public List<Categoria> getLista() {
		try {
			List<Categoria> categorias = new ArrayList<Categoria>();

			PreparedStatement stmt = this.connection.prepareStatement ("select * from categorias");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Categoria categoria = new Categoria (rs.getString("nome"));

				categoria.setId (rs.getInt("id"));

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