package br.com.chamada.central;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author William Martins da Silva
 */
	
public class ChamadaBD {

	private Connection conn = null;
	
	public ChamadaBD() {

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
	
	public boolean incluir(Chamada chamada) {

		boolean resultado = true;

		PreparedStatement ps = null;

		if (conn == null){
			return false;
		}
		
		String sql = "INSERT INTO CHAMADA ( FK_ID_FUNCIONARIO, FK_LOGIN, SENHA, FK_SETOR, IP, FK_EMAIL, FK_SUPORTE," +
				"FK_PRIORIDADE, MENSAGEM, FK_STATUS)" +
				"VALUES (?,?,?,?,?,?,?,?,?,?)";

			Integer fk_id_funcionario = chamada.getFk_id_funcionario();
			String fk_login = chamada.getFk_login();
			String senha = chamada.getSenha();
			Integer fk_setor = chamada.getFk_setor();
			String ip = chamada.getIp();
			String fk_email = chamada.getFk_email();
			Integer fk_suporte = chamada.getFk_suporte();
			Integer fk_prioridade = chamada.getFk_prioridade();
			String mensagem = chamada.getMensagem();
			Integer fk_status = chamada.getFk_status();
			
			try
			{
				ps = conn.prepareStatement(sql);
			
				ps.setInt(1, fk_id_funcionario);
				ps.setString(2, fk_login);
				ps.setString(3, senha);
				ps.setInt(4, fk_setor);
				ps.setString(5, ip);
				ps.setString(6, fk_email);	
				ps.setInt(7, fk_suporte);
				ps.setInt(8, fk_prioridade);
				ps.setString(9, mensagem);
				ps.setInt(10, fk_status);
				
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
	
		public List<Chamada> listaChamada() {

		List<Chamada> lista = new ArrayList<Chamada>();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT C.ID_CHAMADA,F.LOGIN, F.EMAIL,S.NOME SETOR, C.IP, P.NOME PRIORIDADE,T.NOME TIPO_SUPORTE,C.MENSAGEM,ST.NOME STATUS_ATUAL FROM CHAMADA C, FUNCIONARIO F, SETOR S, PRIORIDADE P, TIPO_SUPORTE T, STATUS_ATUAL ST WHERE F.ID_FUNCIONARIO = C.FK_ID_FUNCIONARIO AND F.LOGIN = C.FK_LOGIN AND S.ID_SETOR = C.FK_SETOR AND F.EMAIL = C.FK_EMAIL AND T.ID_SUPORTE = C.FK_SUPORTE AND P.ID_PRIORIDADE = C.FK_PRIORIDADE AND ST.ID_STATUS = C.FK_STATUS");

				while(rs.next()){
										
					Chamada chamada = new Chamada();
					chamada.setId_chamada(rs.getInt(1));
					chamada.setFk_login(rs.getString(2));
					chamada.setFk_email(rs.getString(3));
					chamada.setSetor(rs.getString(4));
					chamada.setIp(rs.getString(5));	
					chamada.setPrioridade(rs.getString(6));
					chamada.setSuporte(rs.getString(7));
					chamada.setMensagem(rs.getString(8));
				    chamada.setSt_atual(rs.getString(9));			
									
					lista.add(chamada);
				}
				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}
}