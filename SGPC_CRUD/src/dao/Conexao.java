package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe de configura��o para a conex�o com o banco de dados
 **/
public class Conexao {

	private static Connection connection;

	/**
	 * Metodo Connection para a configura��o de conex�o com BD
	 **/
	public static Connection getConnection() throws Exception {

		try {

			if (connection == null || connection.isClosed()) {

				// com.mysql.cj.jdbc.Driver
				// com.mysql.jdbc.Driver
				String url = "jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC";
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, "root", "root");
			}

		} catch (Exception e) {
			System.out.println("Erro ao conectar com a mysql :" + e.getMessage());
		}
		return connection;
	}

}
