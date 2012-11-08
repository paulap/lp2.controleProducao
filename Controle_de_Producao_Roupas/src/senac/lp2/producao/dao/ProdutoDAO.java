package senac.lp2.producao.dao;

import java.sql.CallableStatement;
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

	public int produzir(int cod, int quant) throws SQLException {
		connect();
		CallableStatement cs = con.prepareCall("{call fProducao(?, ?, ?)}");
		cs.setInt(1, cod);
		cs.setInt(2, quant);
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		cs.execute();

		return cs.getInt(3);
	}

	public List<Produto> listar() throws SQLException {
		connect();
		List<Produto> lst = new ArrayList<Produto>();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM produtoPronto");

		while (rs.next()) {
			lst.add(new Produto(rs.getInt("codprodutopronto"), rs
					.getString("nome"), rs.getDouble("valor"), rs
					.getInt("quantidade"), rs.getInt("quantmin")));
		}

		return lst;
	}

	public int cadastrar(Produto p) throws SQLException {
		connect();
		CallableStatement cs = con
				.prepareCall("{call fCadastrarProdutoPronto(?, ?, ?, ?, ?)}");
		cs.setString(1, p.getNome());
		cs.setDouble(2, p.getValor());
		cs.setInt(3, p.getQuantidade());
		cs.setInt(4, p.getQuantidadeMinima());
		cs.registerOutParameter(5, java.sql.Types.INTEGER);
		cs.execute();

		return cs.getInt(5);
	}

	public int excluir(int cod, int op) throws SQLException {
		//op : recebe a opção de exclusão
		//se 1, apaga o registro de produto e sua relação com materia
		//se 0, apaga somente o produto caso este não tenha relação com materia
		connect();
		CallableStatement cs = con
				.prepareCall("{call fExcluirProduto(?, ?, ?)}");
		cs.setInt(1, cod);
		cs.setInt(2, op);
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		cs.execute();

		return cs.getInt(3);
	}
	
	public int addMateria(int codProduto, int codMateria, int quantidade) throws SQLException {
		connect();
		CallableStatement cs = con
				.prepareCall("{call fCadastrarMateriaProduto(?, ?, ?, ?)}");
		cs.setInt(1, codProduto);
		cs.setInt(2, codMateria);
		cs.setInt(3, quantidade);
		cs.registerOutParameter(4, java.sql.Types.INTEGER);
		cs.execute();

		return cs.getInt(4);
	}
	
	public int delMateria(int codProduto, int codMateria) throws SQLException {
		connect();
		CallableStatement cs = con
				.prepareCall("{call fExcluirMateriaProduto(?, ?, ?)}");
		cs.setInt(1, codProduto);
		cs.setInt(2, codMateria);
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		cs.execute();

		return cs.getInt(3);
	}
	
	public static void main(String[] args) throws SQLException {
		ProdutoDAO novo = new ProdutoDAO();
		List<Produto> lst = novo.listar();

		for (Produto p : lst) {
			System.out.println(p.getNome() + "          " + p.getQuantidade());
		}
		
		System.out.println(novo.delMateria(3, 2));
		
//		int res = novo.produzir(2, 3);
//
//		System.out.println(res);

//		Produto p = new Produto("Vestido Amarelo", 130.50, 40, 10);
//		
//		System.out.println(novo.cadastrar(p));
	}
}