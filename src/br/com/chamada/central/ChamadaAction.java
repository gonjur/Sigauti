package br.com.chamada.central;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChamadaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChamadaAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ChamadaBD bd = new ChamadaBD();
		Chamada chamada = new Chamada();

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String op = request.getParameter("op");

		out.println("<html>");
		out.println("<head>");
		out.println("<body bgcolor=Yellow>");
		out.println("<title>Central de Chamadas Rei</title>");
		out.println("</head>");
		out.println("<body><center>");
		out.println("<h1><font face='Monotype Corsiva' color='Blue' />Lista de Chamadas</font></h1>");
		
		if (op.equals("incluir")){
			
			String id_funcionario = request.getParameter("fk_id_funcionario");
			Integer fk_id_funcionario = Integer.parseInt(id_funcionario); 
			String fk_login = request.getParameter("fk_login");
			String senha = request.getParameter("senha");
			String setor = request.getParameter("fk_setor");
			Integer fk_setor = Integer.parseInt(setor); 
			String ip = request.getParameter("ip"); 
			String fk_email = request.getParameter("fk_email");
			String suporte = request.getParameter("fk_suporte");
			Integer fk_suporte = Integer.parseInt(suporte); 
			String prioridade = request.getParameter("fk_prioridade");
			Integer fk_prioridade = Integer.parseInt(prioridade); 
			String mensagem = request.getParameter("mensagem");
			String status = request.getParameter("fk_status");
			Integer fk_status = Integer.parseInt(status);  
			
			
			chamada.setFk_id_funcionario(fk_id_funcionario);
			chamada.setFk_login(fk_login);
			chamada.setSenha(senha);
			chamada.setFk_setor(fk_setor);
			chamada.setIp(ip);
			chamada.setFk_email(fk_email);
			chamada.setFk_suporte(fk_suporte);
			chamada.setFk_prioridade(fk_prioridade);
			chamada.setMensagem(mensagem);
			chamada.setFk_status(fk_status);
			
			boolean inc = true;
				inc = bd.incluir(chamada);
				if (inc){
					out.println("Chamada Cadastrada com Sucesso<br/><br/>");
					out.println("<a href='cadastra_chamada.jsp'>Cadastrar Outra</a><br/><br/>");
					
				}else{
					out.println("Nao foi possivel incluir!!!<br/><br/>");
					out.println("<a href='cadastra_chamada.jsp'>Cadastrar Outra</a><br/><br/>");
					
				}
	
		} else if(op.equals("listar")){
			
			List<Chamada> lista = bd.listaChamada();
			
			out.println("<table border=5>");		
			out.println("<th>NºCHAMADA</th>");
			out.println("<th>LOGIN</th>");
			out.println("<th>EMAIL</th>");
			out.println("<th>SETOR</th>");
			out.println("<th>IP</th>");
			out.println("<th>PRIORIDADE</th>");
			out.println("<th>SUPORTE</th>");
			out.println("<th>MENSAGEM</th>");
			out.println("<th>STATUS</th>");
			out.println("<tr>");
			
			for (Chamada l : lista){
				
				out.println("<td>" +l.getId_chamada()+"</td>");
				out.println("<td>" +l.getFk_login()+"</td>");
				out.println("<td>" +l.getFk_email()+"</td>");
				out.println("<td>" +l.getSetor()+"</td>");
				out.println("<td>" +l.getIp()+"</td>");
				out.println("<td>" +l.getPrioridade()+"</td>");
				out.println("<td>" +l.getSuporte()+"</td>");
				out.println("<td>" +l.getMensagem()+"</td>");
				out.println("<td>" +l.getSt_atual()+"</td>");
				
				//out.println("<td><a href='altveiculo.jsp?" +
				//		"modelo="+a.getModelo()+"&"+
				//		"cod_cat="+a.getCodigo_categoria()+"&"+
				//		"potencia="+a.getPotencia()+"&"+
				//		"valor_dia="+a.getValor_diaria()+"&"+
				//		"codigo="+a.getCodigo()+"'>"+
				//		"Editar</a></td>");
				//out.println();

				out.println("</tr>");
				
		}   
		}
		out.println("</table>");
		out.println("<br/>");
		out.println("<a href='area_chamada.jsp'>Voltar </a>");
		out.println("<br/><br/>");
		out.println("<a href='resposta.jsp'>## TESTE de Responder</a>");
		out.println("</center></body>");
		out.println("</html>");		
		bd.fecharConexao();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
