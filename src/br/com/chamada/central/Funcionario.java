package br.com.chamada.central;

public class Funcionario  {
	
	private Integer idFuncionario;
	private String nome;
	private String login;
	private String senha;
	private String cargo;
	private Integer setor;
	private String funcionarioChefe;
	private String email;
	
	private String fk_setor;
	
	
	public String getFk_setor() {
		return fk_setor;
	}
	public void setFk_setor(String fk_setor) {
		this.fk_setor = fk_setor;
	}
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getSetor() {
		return setor;
	}
	public void setSetor(Integer setor) {
		this.setor = setor;
	}
	
	public String getFuncionarioChefe() {
		return funcionarioChefe;
	}
	public void setFuncionarioChefe(String funcionarioChefe) {
		this.funcionarioChefe = funcionarioChefe;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}