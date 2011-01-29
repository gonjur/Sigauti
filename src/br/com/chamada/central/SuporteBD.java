package br.com.chamada.central;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SuporteBD {
	
private Connection conn = null;
	
	public SuporteBD() {

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

	public List<Suporte> listaSuporte() {

		List<Suporte> lista = new ArrayList<Suporte>();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT * FROM TIPO_SUPORTE");
				
				while(rs.next()){
				Suporte suporte = new Suporte();
				suporte.setId_suporte(rs.getInt(1));
				suporte.setNome(rs.getString(2));
				lista.add(suporte);
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
