package br.com.caelum.tudosobreesporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.tudosobreesporte.model.Categoria;
import br.com.caelum.tudosobreesporte.model.Post;

public class PostDao {
	private Connection connection;

	// Construtor.
	public PostDao(Connection connection) {
		this.connection = connection;
	}

	// Método para adicionar o post ao banco de dados.
	public boolean adiciona(Post post) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from posts where titulo = ?");
			stmt.setString(1, post.getTitulo());

			ResultSet rs = stmt.executeQuery();

			// Verifica se o post existe, se existir, não faz nada e retorna falso.
			if(rs.next()) {
				rs.close();
				stmt.close();

				return false;
			}

			// Se o post não existir , ele é criado e adicionado ao banco de dados.
			else {
				String sql = "insert into posts " + "(data_hora, titulo, conteudo, categoria)" + " values (?, ?, ?, ?)";

				stmt = this.connection.prepareStatement(sql);

				stmt.setTimestamp(1, new Timestamp(post.getData().getTimeInMillis()));
				stmt.setString(2, post.getTitulo());
				stmt.setString(3, post.getConteudo());
				stmt.setInt(4, post.getCategoria().getId());
	
				stmt.execute();
				stmt.close();
	
				return true;
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para remoção do post do banco de dados.
	public boolean remove(Integer id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from posts where id = ?");
			stmt.setInt(1, id);

			stmt.execute();
			stmt.close();

			return true;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para listar todos os posts do banco de dados.
	public List<Post> getLista() {
		try {
			List<Post> posts = new ArrayList<Post>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from posts");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				PreparedStatement auxStmt = this.connection.prepareStatement("select * from categorias where id = ?");
				auxStmt.setInt(1, rs.getInt("categoria"));

				ResultSet auxRs = auxStmt.executeQuery();

				if(auxRs.next()) {
					Categoria categoria = new Categoria(auxRs.getString("nome"));
	
					Post post = new Post(rs.getString("titulo"), rs.getString("conteudo"), categoria);
	
					post.setId(rs.getInt("id"));
	
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getTimestamp("data_hora"));
					post.setData(data);
	
					posts.add(post);
				}

				auxRs.close();
				auxStmt.close();
			}

			rs.close();
			stmt.close();

			return posts;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para listar todos os posts do banco de dados de acordo com um filtro (categoria).
	public List<Post> getListaFiltrada(String filtro) {
		try {
			List<Post> posts = new ArrayList<Post>();

			PreparedStatement auxStmt = this.connection.prepareStatement("select * from categorias where nome = ?");
			auxStmt.setString(1, filtro);

			ResultSet auxRs = auxStmt.executeQuery();

			if(auxRs.next()) {
				PreparedStatement stmt = this.connection.prepareStatement("select * from posts where categoria = ?");
				stmt.setInt(1, auxRs.getInt("id"));

				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {
					Categoria categoria = new Categoria(auxRs.getString("nome"));
	
					Post post = new Post(rs.getString("titulo"), rs.getString("conteudo"), categoria);
	
					post.setId(rs.getInt("id"));
	
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getTimestamp("data_hora"));
					post.setData(data);
	
					posts.add(post);
				}

				rs.close();
				stmt.close();
			}

			auxRs.close();
			auxStmt.close();

			return posts;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Método para pegar um post pelo ID.
	public Post getPost(Integer id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from posts where id = ?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				PreparedStatement auxStmt = this.connection.prepareStatement("select * from categorias where id = ?");
				auxStmt.setInt(1, rs.getInt("categoria"));

				ResultSet auxRs = auxStmt.executeQuery();

				if(auxRs.next()) {
					Categoria categoria = new Categoria(auxRs.getString("nome"));

					Post post = new Post(rs.getString("titulo"), rs.getString("conteudo"), categoria);

					post.setId(rs.getInt("id"));

					Calendar data = Calendar.getInstance();
					data.setTime(rs.getTimestamp("data_hora"));
					post.setData(data);

					auxRs.close();
					auxStmt.close();

					rs.close();
					stmt.close();

					return post;
				}
			}

			return null;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}