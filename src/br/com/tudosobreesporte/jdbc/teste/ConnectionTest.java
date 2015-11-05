package br.com.tudosobreesporte.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.tudosobreesporte.jdbc.ConnectionFactory;

public class ConnectionTest {
	public static void main (String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		System.out.println ("Conexão aberta!");

		connection.close();
	}
}