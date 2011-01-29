package br.com.chamada.central;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FuncionarioAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuncionarioAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		FuncionarioBD bd = new FuncionarioBD();
		Funcionario funcionario = new Funcionario();

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String op = request.getParameter("op");

		out.println("<html>");
		out.println("<head>");
		out.println("<body bgcolor=Yellow>");
		out.println("<title>Central de Chamadas Rei</title>");
		out.println("</head>");
		out.println("<body><center>");
		
		if (op.equals("incluir")){
			
			String nome = request.getParameter("nome");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String cargo = request.getParameter("cargo");
			String setor = request.getParameter("id_setor");
			Integer id_setor = Integer.parseInt(setor); 
			String funcionario_chefe = request.getParameter("funcionario_chefe");
			String email = request.getParameter("email");
			
			funcionario.setNome(nome);
			funcionario.setLogin(login);
			funcionario.setSenha(senha);
			funcionario.setCargo(cargo);
			funcionario.setSetor(id_setor);
			funcionario.setFuncionarioChefe(funcionario_chefe);
			funcionario.setEmail(email);
			
			boolean inc = true;
				inc = bd.incluir(funcionario);
				if (inc){
					out.println("Funcionario Cadastrado com Sucesso<br /><br />");
					out.println("<a href='cadastra_funcionario.jsp'>Cadastrar Outro</a><br /><br />");
					
				}else{
					out.println("Nao foi possivel incluir!!!<br /><br />");
					out.println("<a href='cadastra_funcionario.jsp'>Cadastrar Outro</a><br /><br />");
					
				}

			
		} else if(op.equals("listar")){
			
			List<Funcionario> lista = bd.listaFuncionario();
			
			out.println("<table border=5>");		
			out.println("<th>ID_FUNCIONARIO</th>");
			out.println("<th>NOME</th>");
			out.println("<th>LOGIN</th>");
			out.println("<th>SENHA</th>");
			out.println("<th>CARGO</th>");
			out.println("<th>SETOR</th>");
			out.println("<th>FUNCIONARIO_CHEFE</th>");
			out.println("<th>EMAIL</th>");
			out.println("<th>Acao</th>");
			out.println("<th>Acao</th>");
			out.println("<tr>");
			
			for (Funcionario f : lista){
				
				out.println("<td>" +f.getIdFuncionario()+"</td>");
				out.println("<td>" +f.getNome()+"</td>");
				out.println("<td>" +f.getLogin()+"</td>");
				out.println("<td>" +f.getSenha()+"</td>");
				out.println("<td>" +f.getCargo()+"</td>");
				out.println("<td>" +f.getFk_setor()+"</td>");
				out.println("<td>" +f.getFuncionarioChefe()+"</td>");
				out.println("<td>" +f.getEmail()+"</td>");
				out.println("<td><a href='FuncionarioAction?op=excluir&codigo="+f.getIdFuncionario()+"'>Excluir</a></td>");
								
				//out.println("<td><a href='altveiculo.jsp?" +
				//		"modelo="+a.getModelo()+"&"+
				//		"cod_cat="+a.getCodigo_categoria()+"&"+
				//		"potencia="+a.getPotencia()+"&"+
				//		"valor_dia="+a.getValor_diaria()+"&"+
				//		"codigo="+a.getCodigo()+"'>"+
				//		"Editar</a></td>");
				//out.println("<td><a href='VeicAction?op=4&codigo="+a.getCodigo()+"'>Excluir</a></td>");
				out.println("</tr>");
		}   
		}
		out.println("</table>");
		out.println("</br>");
		out.println("<a href='area_funcionario.jsp'>Voltar </a>");
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
