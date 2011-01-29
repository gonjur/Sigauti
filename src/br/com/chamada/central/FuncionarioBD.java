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
	
public class FuncionarioBD {

	private Connection conn = null;
	
	public FuncionarioBD() {

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
	
	public boolean incluir(Funcionario funcionario) {

		boolean resultado = true;

		PreparedStatement ps = null;

		if (conn == null){
			return false;
		}
		
		String sql = "INSERT INTO FUNCIONARIO ( NOME, LOGIN, SENHA, CARGO, FK_SETOR, FUNCIONARIO_CHEFE, EMAIL)" +
				"VALUES (?,?,?,?,?,?,?)";

			String nome = funcionario.getNome();
			String login = funcionario.getLogin();
			String senha = funcionario.getSenha();
			String cargo = funcionario.getCargo();
			Integer idSetor = funcionario.getSetor();
			String funcionario_chefe = funcionario.getFuncionarioChefe();
			String email = funcionario.getEmail();
			
			try
			{
				ps = conn.prepareStatement(sql);
			
				ps.setString(1, nome);
				ps.setString(2, login);
				ps.setString(3, senha);
				ps.setString(4, cargo);
				ps.setInt(5, idSetor);
				ps.setString(6, funcionario_chefe);	
				ps.setString(7, email);
				
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
	
		public List<Funcionario> listaFuncionario() {

		List<Funcionario> lista = new ArrayList<Funcionario>();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT  F.ID_FUNCIONARIO, F.NOME, F.LOGIN, F.SENHA, F. CARGO, S.NOME SETOR, F.FUNCIONARIO_CHEFE, F.EMAIL FROM FUNCIONARIO F, SETOR S WHERE F.ID_FUNCIONARIO = S.ID_SETOR");

				while(rs.next()){
										
					Funcionario funcionario = new Funcionario();
					funcionario.setIdFuncionario(rs.getInt(1));
					funcionario.setNome(rs.getString(2));
					funcionario.setLogin(rs.getString(3));
					funcionario.setSenha(rs.getString(4));
					funcionario.setCargo(rs.getString(5));	
					funcionario.setFk_setor(rs.getString(6));
					funcionario.setFuncionarioChefe(rs.getString(7));
					funcionario.setEmail(rs.getString(8));
					lista.add(funcionario);
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