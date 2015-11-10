package br.com.caelum.tudosobreesporte.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;
import br.com.caelum.tudosobreesporte.model.Post;

public class PostDao {
	private Connection connection;

	public PostDao(Connection connection) {
		this.connection = connection;
	}

	public PostDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona (Post post) {
		String sql = "insert into posts " + "(data_hora, titulo, conteudo, tags)" + " values (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setTimestamp(1, new Timestamp(post.getData().getTimeInMillis()));
			stmt.setString(2, post.getTitulo());
			stmt.setString(3, post.getConteudo());
			stmt.setString(4, post.getTags());

			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove (int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from posts where id=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	public List<Post> getLista() {
		try {
			List<Post> posts = new ArrayList<Post>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from posts");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Post post = new Post();

				post.setId(rs.getInt("id"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getTimestamp("data_hora"));
				post.setData(data);

				post.setTitulo(rs.getString("titulo"));
				post.setConteudo(rs.getString("conteudo"));
				post.setTags(rs.getString("tags"));

				posts.add(post);
			}
			rs.close();
			stmt.close();

			return posts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Post> getListaFiltrada(String filtro) {
		try {
			List<Post> posts = new ArrayList<Post>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from posts where tags like ?");
			stmt.setString(1, "%" + filtro + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Post post = new Post();

				post.setId(rs.getInt("id"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_hora"));
				post.setData(data);

				post.setTitulo(rs.getString("titulo"));
				post.setConteudo(rs.getString("conteudo"));
				post.setTags(rs.getString("tags"));

				posts.add(post);
			}
			rs.close();
			stmt.close();

			return posts;
		
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	public List<Post> getPost(int id) {
		try {
			List<Post> posts = new ArrayList<Post>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from posts where id=" + id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Post post = new Post();

				post.setId(rs.getInt("id"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_hora"));
				post.setData(data);

				post.setTitulo(rs.getString("titulo"));
				post.setConteudo(rs.getString("conteudo"));
				post.setTags(rs.getString("tags"));

				posts.add(post);
			}
			rs.close();
			stmt.close();

			return posts;
		
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

}