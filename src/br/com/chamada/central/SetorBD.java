package br.com.chamada.central;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SetorBD {

	private Connection conn = null;
	
	public SetorBD() {

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
	
	// Método que Inclui
	public boolean incluir(Setor setor) {

		boolean resultado = true;

		PreparedStatement ps = null;

		if (conn == null){
			return false;
		}
		
		String sql = "INSERT INTO SETOR (NOME) VALUES (?)";

			String nome = setor.getNomeSetor();
			
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setString(1, nome);
				ps.executeUpdate();
				resultado = true;
				
			}catch(SQLException ex){
				resultado = false;
				System.out.println("erro no seu codigo");
				System.err.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}finally{
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return resultado;
	}
	
	
/*	public boolean excluir(Setor setor)  {
		
		boolean resultado = true;
		PreparedStatement ps = null;
		
		
		String sql = "DELETE FROM SETOR WHERE ID_SETOR="+setor.getIdSetor();
	
		try
		{
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			resultado = true;
			
		}catch(SQLException ex){
			resultado = false;
			System.out.println("erro no seu codigo");
			System.err.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return resultado;
	}
	*/
	
	/*
	public boolean altera(Setor setor) {

		boolean resultado = true;

		PreparedStatement ps = null;

		if (conn == null){
			return false;
		}
		
		String sql = "ALTER INTO SETOR (NOME) VALUES (?)";

			String nome = setor.getNomeSetor();
			
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setString(1, nome);
				ps.executeUpdate();
				resultado = true;
				
			}catch(SQLException ex){
				resultado = false;
				System.out.println("erro no seu codigo");
				System.err.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}finally{
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return resultado;
	}
	
	
	public Setor buscar(Integer idSetor){
	
		return new Setor();
	}
	*/
	
	public List<Setor> listaSetor() {

		List<Setor> lista = new ArrayList<Setor>();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT * FROM SETOR");
				
				while(rs.next()){
				Setor setor = new Setor();
				setor.setIdSetor(rs.getInt(1));
				setor.setNomeSetor(rs.getString(2));
				lista.add(setor);
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
