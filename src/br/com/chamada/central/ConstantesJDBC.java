package br.com.chamada.central;

/**
 * Classe    : ConstantesJDBC.java
 * Descri��o : Classe utilizada para conectar em diversos bancos de dados.
 * 
 * @author William Martins da Silva
 */
public class ConstantesJDBC {

	public final static String ACCESS_DRIVER    = "sun.jdbc.odbc.JdbcOdbcDriver";
	public final static String ACCESS_URL       = "jdbc:odbc:locadora";
	public final static String ACCESS_USER      = "";
	public final static String ACCESS_PASS      = "";
	
	public final static String FIREBIRD_DRIVER    = "org.firebirdsql.jdbc.FBDriver";
	public final static String FIREBIRD_URL       = "jdbc:firebirdsql:localhost/3050:c:/Temp/CURSOJAVA.fdb";
	public final static String FIREBIRD_USER      = "SYSDBA";
	public final static String FIREBIRD_PASS      = "masterkey";
	
	public final static String INTERBASE_DRIVER    = "org.firebirdsql.jdbc.FBDriver";
	public final static String INTERBASE_URL       = "jdbc:firebirdsql:localhost/3050:c:/Temp/Dados.fdb";
	public final static String INTERBASE_USER      = "SYSDBA";
	public final static String INTERBASE_PASS      = "masterkey";
	
	public final static String MYSQL_DRIVER     = "com.mysql.jdbc.Driver";
	public final static String MYSQL_URL        = "jdbc:mysql://localhost:3306/central_chamadas";
	public final static String MYSQL_USER       = "root";
	public final static String MYSQL_PASS       = "admin";

	public final static String ORACLE_DRIVER    = "oracle.jdbc.driver.OracleDriver";
	public final static String ORACLE_URL       = "jdbc:oracle:thin:@10.8.10.10:1525:CursoJava";
	public final static String ORACLE_USER      = "";
	public final static String ORACLE_PASS      = "";
	
	public final static String POSTGREE_DRIVER  = "org.postgresql.Driver";
	public final static String POSTGREE_URL     = "jdbc:postgresql://localhost:5432/CursoJava";
	public final static String POSTGREE_USER    = "";
	public final static String POSTGREE_PASS    = "";
	
	public final static String SQLSERVER_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	public final static String SQLSERVER_URL    = "jdbc:microsoft:sqlserver://10.15.1.30;DatabaseName=CursoJava";
	public final static String SQLSERVER_USER   = "";
	public final static String SQLSERVER_PASS   = "";
	
}
