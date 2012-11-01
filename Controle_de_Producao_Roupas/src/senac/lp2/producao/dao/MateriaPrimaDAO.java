package senac.lp2.producao.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import senac.lp2.producao.classes.MateriaPrima;

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
			lst.add(new MateriaPrima(rs.getLong("codmateriaprima"), rs
					.getString("nome"), rs.getDouble("valor"), rs
					.getString("unidade"), rs.getLong("quantidade"), rs
					.getLong("quantmin")));
		}

		return lst;
	}

	public static void main(String[] args) throws SQLException {
		MateriaPrimaDAO novo = new MateriaPrimaDAO();
		List<MateriaPrima> lst = novo.listar();

		for (MateriaPrima m : lst) {
			System.out.println(m.getNome() + "          " + m.getQuantidade());
		}

	}
}
