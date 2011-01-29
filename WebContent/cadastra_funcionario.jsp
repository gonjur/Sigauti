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
%>

</head>
<body bgcolor="Yellow">

<h1><u><font face= "Monotype Corsiva" color="Blue" />Cadastro de Funcionário</font></u></h1>
<form action="FuncionarioAction" method="get">

<table border="0">
<tr>
<td><b>Nome:</b></td>
	<td><input type="text" name="nome" maxlength="50" size="50" /></td>
</tr>

<tr>
<td><b>Login:</b></td>
	<td><input type="text" name="login" maxlength="50" size="50" /></td>
</tr>

<tr>
<td><b>Senha:</b></td>
	<td><input type="password" name="senha" maxlength="50" size="50" /></td>
</tr>

<td><b>Cargo:</b></td>
	<td><input type="text" name="cargo" maxlength="50" size="50" /></td>
</tr>

<tr>
<td><b>Setor:</b></td>
	<td>
	<select name="id_setor">
<% for (Setor s : lista){ %>
<option value="<%=s.getIdSetor() %>"><%=s.getNomeSetor() %></option>
<%} %>
	</select></td>
</tr>

<tr>
<td><b>Funcionário Chefe:</b></td>
	<td><input type="text" name="funcionario_chefe" maxlength="50" size="50" /></td>
</tr>

<tr>
<td><b>Email:</b></td>
	<td><input type="text" name="email" maxlength="50" size="50" /></td>
</tr><td> </td>
<th><input type="submit" name="enviar" value="Cadastrar" />
<input type="reset" name="limpar" value="Limpar" />
</th>

</table>
<input type="hidden" name="op" value="incluir" />
</form>
<br /><b>
<a href="area_funcionario.jsp">Voltar</a></b>
<p /><br />

</body>
</html>