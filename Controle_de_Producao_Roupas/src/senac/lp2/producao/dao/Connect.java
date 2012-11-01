package senac.lp2.producao.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	private Connection con = null;

	public void connect() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/producao", "postgres",
				"senacrs");

		// Statement stmt = con.createStatement();
		// ResultSet rs = stmt.executeQuery("SELECT * FROM produtoPronto");
		//
		// while (rs.next()) {
		// String s = rs.getString("nome");
		// System.out.println(s);
		// }
	}

	public Connection getConnect() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/producao", "postgres",
				"senacrs");
		return con;
	}
}