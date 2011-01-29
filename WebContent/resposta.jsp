<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@page import="br.com.chamada.central.*" %>
<%@page import="java.text.DateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Central de Chamadas Rei</title>
<% 
	ChamadaBD cha = new ChamadaBD();
	List<Chamada> lista = cha.listaChamada();
%>
</head>
<body bgcolor="Yellow">
<center>
<h1><font face= "Monotype Corsiva" color="Blue" />Central de Chamadas</font></h1>
		<table border=5>		
			<th>NºCHAMADA</th>
			<th>LOGIN</th>
			<th>EMAIL</th>
			<th>SETOR</th>
			<th>IP</th>
			<th>PRIORIDADE</th>
			<th>SUPORTE</th>
			<th>MENSAGEM</th>
			<th>STATUS</th>
			<tr>
			
			<% for (Chamada c : lista){ %>
							
				<td><%=c.getId_chamada()%></a>
				<td><%=c.getFk_login()%></td>
				<td><%=c.getFk_email()%></td>
				<td><%=c.getSetor()%></td>
				<td><%=c.getIp()%></td>
				<td><%=c.getPrioridade()%></td>
				<td><%=c.getSuporte()%></td>
				<td><%=c.getMensagem()%></td>
				<td><%=c.getSt_atual()%></td>
				</tr>	
				<%} %>
		</table>
		<br/><br/>
		
		<div><b>Responder:</b></div>
		<textarea name="resposta" value="resposta" rows="10" cols="40"></textarea></td>
		<br/><br/>
		<input type="submit" name="enviar" value="Enviar" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" name="limpar" value="Limpar" />
		<br/><br/>
		
		<table align="center" width="40%" border="1" cellspacing="5" cellpadding="5" >
		<tr>
		<td width="20%" align="right">Hora:</td>
		<td width="80%" ><%=DateFormat.getTimeInstance().format(new Date())%></td>
		</tr>
		</table><br/>
		
		<a href='area_chamada.jsp'>Voltar </a>
</center>		
</body>
</html>