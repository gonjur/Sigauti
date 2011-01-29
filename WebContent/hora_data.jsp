<%@page import="java.util.*" %>
<%@page import="java.text.DateFormat" %>

<center>
<table align="center" width="40%" border="1" cellspacing="5" cellpadding="5" >
	<tr>
		<td width="20%" align="right">Hora:</td>
		<td width="80%" ><%=DateFormat.getTimeInstance(DateFormat.LONG,new Locale("pt","BR")).format(new Date())%></td>
	</tr>
</table>

<table align="center" width="40%" border="1" cellspacing="5" cellpadding="5" >
	<tr>
		<td width="20%" align="right">Data:</td>
		<td width="80%" ><%=DateFormat.getDateInstance(DateFormat.LONG,
				new Locale("pt","BR")).format(new Date())%></td>
	</tr>
</table>
</center>