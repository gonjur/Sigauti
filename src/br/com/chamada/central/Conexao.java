package br.com.chamada.central;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.ast.Statement;

public class Conexao {
	
	private static Connection conexao = null;
	//private static Logger log = Logger.getLogger(Conexao.class.getName());
	public static java.sql.Statement stm;
	
	public static Connection  conectar(String driver, String url, String usuario,
			String senha) {

		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usuario, senha);
			
			SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
			
			//log.info("O usuario '" +usuario.toUpperCase()+ "' conectou no "+url+" na hora " + s.format(new Date()));
			
			//log.info("Conexão Realizada com sucesso!");
			stm = conexao.createStatement();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//log.error("ClassNotFoundException " + e.getMessage());
			//log.error("Não encontrou o driver do Banco de Dados!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			//log.error("SQLException " + e.getMessage());
		}
		return conexao;
	}

	public static void desconectar(Connection pConexao){
		try {
			if(pConexao != null){
				pConexao.close();
				//log.info("Desconectou com sucesso!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//log.error("Problemas para desconectar!");
		}
	}
}
