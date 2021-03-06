package senac.lp2.producao.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import senac.lp2.producao.classes.MateriaPrima;
import senac.lp2.producao.classes.Produto;

public class MateriaPrimaDAO {
	private Connection con = null;

	public void connect() throws Exception {
		Connect connect = new Connect();
		con = connect.getConnect();
	}

	public List<MateriaPrima> listar() throws Exception {
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

		con.close();
		
		return lst;
	}

	public List<MateriaPrima> listar(int codMateria) throws Exception {
		connect();
		List<MateriaPrima> lst = new ArrayList<MateriaPrima>();

		PreparedStatement ps = con.prepareStatement("SELECT * FROM materiaPrima where codMateriaPrima  = ?");
		
		ps.setInt(1, codMateria);
		
		ResultSet rs = ps.executeQuery();
				
		while (rs.next()) {
			lst.add(new MateriaPrima(rs.getInt("codMateriaPrima"), rs
					.getString("nome"), rs.getDouble("valor"), rs.getString("unidade"), rs
					.getInt("quantidade"), rs.getInt("quantmin")));
		}

		con.close();
		
		return lst;
	}
	
	public int cadastrar(MateriaPrima m) throws Exception {
		connect();
		CallableStatement cs = con
				.prepareCall("{call fCadastrarMateriaPrima(?, ?, ?, ?, ?, ?)}");
		cs.setString(1, m.getNome());
		cs.setDouble(2, m.getValor());
		cs.setString(3, m.getUnidade());
		cs.setInt(4, m.getQuantidade());
		cs.setInt(5, m.getQuantidadeMinima());
		cs.registerOutParameter(6, java.sql.Types.INTEGER);
		cs.execute();

		int res = cs.getInt(6);

		con.close();
		
		return res;
	}

	public int excluir(int cod, int op) throws Exception {
		// op : recebe a op��o de exclus�o
		// se 1, apaga o registro de materia e sua rela��o com produto
		// se 0, apaga somente a materia caso esta n�o tenha rela��o com
		// produtos
		connect();
		CallableStatement cs = con
				.prepareCall("{call fExcluirMateriaPrima(?, ?, ?)}");
		cs.setInt(1, cod);
		cs.setInt(2, op);
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		cs.execute();

		int res = cs.getInt(3);
		
		con.close();
		
		return res;
	}

	public static void main(String[] args) throws Exception {
		MateriaPrimaDAO novo = new MateriaPrimaDAO();
		List<MateriaPrima> lst = novo.listar(2);

		for (MateriaPrima m : lst) {
			System.out.println(m.getNome() + "          " + m.getQuantidade());
		}

		System.out.println(novo.excluir(1, 1));

		// MateriaPrima m = new MateriaPrima("Tecido Azul", 15.50, "metro", 100,
		// 30);
		// System.out.println(novo.cadastrar(m));
	}
}
