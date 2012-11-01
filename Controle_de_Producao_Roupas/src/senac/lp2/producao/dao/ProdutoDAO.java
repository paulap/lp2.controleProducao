package senac.lp2.producao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;
import senac.lp2.producao.classes.Produto;

public class ProdutoDAO {
	Connection con = null;

	public void connect() throws SQLException {
		Connect connect = new Connect();
		con = connect.getConnect();
	}

	public List<Produto> listar() throws SQLException {
		connect();
		List<Produto> lst = new ArrayList<Produto>();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM produtoPronto");

		while (rs.next()) {
			lst.add(new Produto(rs.getLong("codprodutopronto"), rs
					.getString("nome"), rs.getDouble("valor"), rs
					.getLong("quantidade"), rs.getLong("quantmin")));
		}

		return lst;
	}

	public static void main(String[] args) throws SQLException {
		ProdutoDAO novo = new ProdutoDAO();
		List<Produto> lst = novo.listar();

		for (Produto p : lst) {
			System.out.println(p.getNome() + "          " + p.getQuantidade());
		}

	}
}