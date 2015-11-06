package br.com.tudosobreesporte.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.tudosobreesporte.jdbc.ConnectionFactory;
import br.com.tudosobreesporte.jdbc.posts.Posts;

public class PostsDao {
	private Connection connection;

	public PostsDao(Connection connection) {
		this.connection = connection;
	}

	public PostsDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona (Posts post) {
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

	public List<Posts> getLista() {
		try {
			List<Posts> posts = new ArrayList<Posts>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from posts");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Posts post = new Posts();

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
			throw new RuntimeException(e);
		}
	}

	public List<Posts> getListaFiltrada(String filtro) {
		try {
			List<Posts> posts = new ArrayList<Posts>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from posts where tags like ?");
			stmt.setString(1, "%" + filtro + "%");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Posts post = new Posts();

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