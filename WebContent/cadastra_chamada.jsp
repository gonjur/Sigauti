<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@page import="br.com.chamada.central.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Central de Chamadas Rei</title>

<% 
	FuncionarioBD fun = new FuncionarioBD();
	List<Funcionario> funlista = fun.listaFuncionario();

	SetorBD set = new SetorBD();
	List<Setor> setlista = set.listaSetor();
	
	SuporteBD sup = new SuporteBD();
	List<Suporte> suplista=  sup.listaSuporte();
	
	PrioridadeBD pri = new PrioridadeBD();
	List<Prioridade> prilista=  pri.listaPrioridade();
	
	StatusBD sta = new StatusBD();
	List<Status> stalista=  sta.listaStatus();
	
%>

</head>
<center>
<body bgcolor="Yellow">

<h1><u><font face= "Monotype Corsiva" color="Blue" />Cadastro de Chamada</font></u></h1>
<form action="ChamadaAction" method="get">

<table border="0">
<tr>
<td></td>
	<td>
	<select name="fk_id_funcionario">
<% for (Funcionario f2 : funlista){ %>
<option value="<%=f2.getIdFuncionario() %>"><%=f2.getIdFuncionario() %></option>
<%} %>
	</select></td>
</tr>
<tr>
<td><b>Login:</b></td>
	<td>
	<select name="fk_login">
<% for (Funcionario f2 : funlista){ %>
<option value="<%=f2.getLogin() %>"><%=f2.getLogin() %></option>
<%} %>
	</select></td>
</tr>

<tr>
<td><b>Senha:</b></td>
	<td><input type="password" name="senha" maxlength="50" size="50" /></td>
</tr>

<tr>
<td><b>Setor:</b></td>
	<td>
	<select name="fk_setor">
<% for (Setor st : setlista){ %>
<option value="<%=st.getIdSetor() %>"><%=st.getNomeSetor() %></option>
<%} %>
	</select></td>
</tr>

<tr>
<td><b>Ip do computador:</b></td>
	<td><input type="text" name="ip" maxlength="13" size="15" /></td>
</tr>

<tr>
<td><b>Email:</b></td>
	<td><input type="text" name="fk_email" maxlength="50" size="50" /></td>
</tr>

<tr>
<td><b>Tipo de Suporte:</b></td>
	<td>
	<select name="fk_suporte">
<% for (Suporte sp : suplista){ %>
<option value="<%=sp.getId_suporte() %>"><%=sp.getNome() %></option>
<%} %>
	</select></td>
</tr>

<td><b>Prioridade:</b></td>
	<td>
	<select name="fk_prioridade">
<% for (Prioridade p : prilista){ %>
<option value="<%=p.getId_prioridade() %>"><%=p.getNome() %></option>
<%} %>
	</select></td>
</tr>

<tr>
<td><b><div>Descreva o problema:</div></b></td>
	<td><textarea name="mensagem" rows="10" cols="50"></textarea></td>
</tr>

<tr>
<td><b></b></td>
	<td>
	<input type="hidden" name="fk_status" value="1">
</tr>

<td> </td>
<th><input type="submit" name="enviar" value="Cadastrar" />
<input type="reset" name="limpar" value="Limpar" />
</th>

</table>
<input type="hidden" name="op" value="incluir" />
</form>
<br /><b>
<a href="area_chamada.jsp">Voltar</a></b>
<p /><br />
</center>
</body>
</html>