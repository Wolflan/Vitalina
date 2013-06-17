package recurso;

import java.sql.*;

public class FabricaDeConexao {

	public static Connection getConnection() throws SQLException {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/vitalina","root","lasombra");
		}
		catch (ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
		
	}
	
}
