package br.com.caelum.tudosobreesporte.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	static {
		try {
			Class.forName ("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException (e);
		}
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection ("jdbc:mysql://localhost:25565/tudoSobreEsporte", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
}