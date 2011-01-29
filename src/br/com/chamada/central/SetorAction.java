package br.com.chamada.central;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SetorAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetorAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SetorBD bd = new SetorBD();
		Setor setor = new Setor();

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String op = request.getParameter("op");

		out.println("<html>");
		out.println("<head>");
		out.println("<body bgcolor=Yellow>");
		out.println("<title>Central de Chamadas Rei</title>");
		out.println("</head>");
		out.println("<body><center><b>");
		
		// Metodo que verifica a inclusao
		if (op.equals("incluir")){
			
			String nome = request.getParameter("nome");
			setor.setNomeSetor(nome);
		
			boolean inc = true;
				inc = bd.incluir(setor);
				if (inc){
					out.println("Setor Cadastrado com Sucesso<br /><br />");
					out.println("<a href='cadastra_setor.jsp'>Cadastrar Outro Setor</a><br /><br />");
					out.println("<a href='area_adm.jsp'>Voltar </a>");
				}else{
					out.println("Nao foi possivel incluir!!!<br /><br />");
					out.println("<a href='cadastra_setor.jsp'>Cadastrar Outro Setor</a><br /><br />");
					out.println("<a href='area_adm.jsp'>Voltar </a>");
				}
		}
		
		/*	else if (op.equals("excluir")){
				
				
				setor.setIdSetor(Integer.parseInt(request.getParameter("id")));
				
				
				
				boolean exc = true;
					exc = bd.excluir(setor);
					if (exc){
				out.println("Veiculo Excluido com sucesso<br />");
				out.println("<a href='cadastra_setor.jsp'>Cadastrar Outro Setor</a><br /><br />");
				out.println("<a href='area_adm.html'>Voltar </a>");
				
			}else{
				out.println("Nao foi possivel excluir!!!<br />");
				out.println("<a href='cadastra_setor.jsp'>Cadastrar Outro Setor</a><br /><br />");
				out.println("<a href='area_adm.html'>Voltar </a>");				
			}
		out.println("</b></center></body>");
		out.println("</html>");
		
		bd.fecharConexao();
			} */
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
