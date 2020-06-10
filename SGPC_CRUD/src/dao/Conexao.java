package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static Connection connection;

	public static Connection getConnection() throws Exception {

		try {

			if (connection == null || connection.isClosed()) {
				
				//com.mysql.cj.jdbc.Driver
				//com.mysql.jdbc.Driver
				String url = "jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC";
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url,"root","root");
			}

		} catch (Exception e) {
			System.out.println("Erro ao conectar com a mysql :" + e.getMessage());
		}
		return connection;
	}

}
