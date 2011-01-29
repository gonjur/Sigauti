package br.com.chamada.central;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrioridadeBD {
	
private Connection conn = null;
	
	public PrioridadeBD() {

		try {
			conn = Conexao.conectar(ConstantesJDBC.MYSQL_DRIVER,
					ConstantesJDBC.MYSQL_URL, ConstantesJDBC.MYSQL_USER,
					ConstantesJDBC.MYSQL_PASS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fecharConexao(){
		Conexao.desconectar(conn);
	}

	public List<Prioridade> listaPrioridade() {

		List<Prioridade> lista = new ArrayList<Prioridade>();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT * FROM PRIORIDADE");
				
				while(rs.next()){
				Prioridade prioridade = new Prioridade();
				prioridade.setId_prioridade(rs.getInt(1));
				prioridade.setNome(rs.getString(2));
				lista.add(prioridade);
			}
			rs.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}
}
