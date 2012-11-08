package senac.lp2.producao.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	private Connection con = null;

	public Connection getConnect() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/producao", "postgres",
				"senacrs");
		return con;
	}
	
	public void close() throws SQLException {
		con.close();
	}
}