package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestConnectionDB {

	public static void main(String[] args) throws Exception {

		Connection connection = new TestConnectionDB().getConnection();
        System.out.println("Conexão aberta!");
        
        // cria um preparedStatement
        String sql = "INSERT INTO produto(id,"
				+ " nome,"
				+ " descricao,"		
				+ " quantidade,"
				+ "obs)"
				+ "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        // preenche os valores
        ps.setInt(1, 10);
		ps.setString(2, "teste");
		ps.setString(3, "teste");
		ps.setInt(4, 0);
		ps.setString(5, "teste");
       

        // executa
        ps.execute();
        ps.close();

        System.out.println("Gravado!");
        
        connection.close();
	}
	
	 public Connection getConnection() {
	        try {
	            return DriverManager.getConnection(
	                    "jdbc:mysql://localhost/test", "root", "root");
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

}
