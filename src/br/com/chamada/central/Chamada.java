package br.com.chamada.central;

public class Chamada  {
	
	private Integer id_chamada;
	private Integer fk_id_funcionario;
	private String fk_login;
	private String senha;
	private Integer fk_setor;
	private String ip;
	private String fk_email;
	private Integer fk_suporte;
	private Integer fk_prioridade;
	private String mensagem;
	private Integer fk_status;
	
	private String setor;
	private String prioridade;
	private String suporte;
	private String st_atual;	
	
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getSuporte() {
		return suporte;
	}
	public void setSuporte(String suporte) {
		this.suporte = suporte;
	}
	public String getSt_atual() {
		return st_atual;
	}
	public void setSt_atual(String st_atual) {
		this.st_atual = st_atual;
	}

	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public Integer getId_chamada() {
		return id_chamada;
	}
	public void setId_chamada(Integer id_chamada) {
		this.id_chamada = id_chamada;
	}
	public Integer getFk_id_funcionario() {
		return fk_id_funcionario;
	}
	public void setFk_id_funcionario(Integer fk_id_funcionario) {
		this.fk_id_funcionario = fk_id_funcionario;
	}
	public String getFk_login() {
		return fk_login;
	}
	public void setFk_login(String fk_login) {
		this.fk_login = fk_login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getFk_setor() {
		return fk_setor;
	}
	public void setFk_setor(Integer fk_setor) {
		this.fk_setor = fk_setor;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFk_email() {
		return fk_email;
	}
	public void setFk_email(String fk_email) {
		this.fk_email = fk_email;
	}
	public Integer getFk_suporte() {
		return fk_suporte;
	}
	public void setFk_suporte(Integer fk_suporte) {
		this.fk_suporte = fk_suporte;
	}
	public Integer getFk_prioridade() {
		return fk_prioridade;
	}
	public void setFk_prioridade(Integer fk_prioridade) {
		this.fk_prioridade = fk_prioridade;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Integer getFk_status() {
		return fk_status;
	}
	public void setFk_status(Integer fk_status) {
		this.fk_status = fk_status;
	}
	
}