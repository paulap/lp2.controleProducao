package senac.lp2.producao.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import senac.lp2.producao.classes.MateriaPrima;
import senac.lp2.producao.classes.Produto;

public class MateriaPrimaDAO {
	Connection con = null;

	public void connect() throws SQLException {
		Connect connect = new Connect();
		con = connect.getConnect();
	}

	public List<MateriaPrima> listar() throws SQLException {
		connect();
		List<MateriaPrima> lst = new ArrayList<MateriaPrima>();

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM materiaPrima");

		while (rs.next()) {
			lst.add(new MateriaPrima(rs.getInt("codmateriaprima"), rs
					.getString("nome"), rs.getDouble("valor"), rs
					.getString("unidade"), rs.getInt("quantidade"), rs
					.getInt("quantmin")));
		}

		return lst;
	}

	public int cadastrar(MateriaPrima m) throws SQLException {
		connect();
		CallableStatement cs = con.prepareCall("{call fCadastrarMateriaPrima(?, ?, ?, ?, ?, ?)}");
		cs.setString(1, m.getNome());
		cs.setDouble(2, m.getValor());
		cs.setString(3, m.getUnidade());
		cs.setInt(4, m.getQuantidade());
		cs.setInt(5, m.getQuantidadeMinima());
		cs.registerOutParameter(6, java.sql.Types.INTEGER);
		cs.execute();

		return cs.getInt(6);
	}
	
	public int excluir(int cod, int op) throws SQLException {
		//op : recebe a opção de exclusão
		//se 1, apaga o registro de materia e sua relação com produto
		//se 0, apaga somente a materia caso esta não tenha relação com produtos
		connect();
		CallableStatement cs = con
				.prepareCall("{call fExcluirMateriaPrima(?, ?, ?)}");
		cs.setInt(1, cod);
		cs.setInt(2, op);
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		cs.execute();

		return cs.getInt(3);
	}
	
	public static void main(String[] args) throws SQLException {
		MateriaPrimaDAO novo = new MateriaPrimaDAO();
		List<MateriaPrima> lst = novo.listar();

		for (MateriaPrima m : lst) {
			System.out.println(m.getNome() + "          " + m.getQuantidade());
		}

		System.out.println(novo.excluir(1, 1));
		
//		MateriaPrima m = new MateriaPrima("Tecido Azul", 15.50, "metro", 100, 30);
//		System.out.println(novo.cadastrar(m));
	}
}
