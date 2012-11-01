package senac.lp2.producao.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class MateriaProdutoDAO {
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

	public static void main(String[] args) throws SQLException {
		MateriaProdutoDAO m = new MateriaProdutoDAO();
		int res = m.produzir(1, 10);

		System.out.println(res);
	}
}
