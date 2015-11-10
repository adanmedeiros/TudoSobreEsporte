package br.com.caelum.tudosobreesporte.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.tudosobreesporte.factory.ConnectionFactory;

public class ConnectionTest {
	public static void main (String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		System.out.println ("Conexão aberta!");

		connection.close();
	}
}