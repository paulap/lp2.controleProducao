package senac.lp2.producao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import senac.lp2.producao.classes.Produto;

public class ProdutoDAO {
	Connection con = null;
	Produto produto = null;

	public Connection conexao() throws SQLException {
		// TODO Conexão;
		return con;
	}

	public List<Produto> listar() throws SQLException {
		 conexao();
		 List<Produto> lst = new ArrayList<Produto>();
		 ResultSet listarProduto = null;
		
		 Statement stmt = conexao().createStatement();
		 ResultSet rs = stmt.executeQuery("SELECT * FROM produtoPronto");
		
		 while (rs.next()) {
			 //TODO
			 lst.add(new Produto());
//			 String s = rs.getString("nome");
//			 System.out.println(s);
		 }
		
		 return lst;
	}
}
