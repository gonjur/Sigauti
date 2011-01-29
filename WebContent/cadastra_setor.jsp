<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@page import="br.com.chamada.central.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Central de Chamadas Rei</title>

	<% 
	SetorBD bd = new SetorBD();
	List<Setor> lista = bd.listaSetor();
	out.println("<table border=5 />");	
	out.println("<th>ID_SETOR</th>");
	out.println("<th>NOME</th>");
	out.println("<th>Ação</th>");
	out.println("<th>Ação</th>");
	out.println("</tr>");
	
	for (Setor a : lista){
		out.println("<tr>");
		out.println("<td>" +a.getIdSetor()+"</td>");
		out.println("<td>"+a.getNomeSetor()+"</td>");
		
		//out.println("<td><a href='altveiculo.jsp?" +
		//		"modelo="+a.getModelo()+"&"+
		//		"cod_cat="+a.getCodigo_categoria()+"&"+
		//		"potencia="+a.getPotencia()+"&"+
		//		"valor_dia="+a.getValor_diaria()+"&"+
		//		"codigo="+a.getCodigo()+"'>"+
		//		"Editar</a></td>");
		//out.println("<td><a href='SetorAction?op=excluir&id="+a.getIdSetor()+"'>Excluir</a></td>");
		out.println("</tr>");
	}
%>

</head>
<body bgcolor="Yellow">

<h1><u><font face= "Monotype Corsiva" color="Blue" />Cadastro de Setor</font></u></h1>
<form action="SetorAction" method="get">
<table border="0">
<tr>
<br><td><b>Nome:</b></td>
	<td><input type="text" name="nome" maxlength="50" size="50" /></td>
</tr>

<td> </td>
<th><input type="submit" name="enviar" value="Cadastrar" />
<input type="reset" name="limpar" value="Limpar" />
<br><br><a href="area_adm.jsp">Voltar</a></b>
</th>
</table>
<input type="hidden" name="op" value="incluir" />
</form>
<b>
<p/><br />

</body>
</html>