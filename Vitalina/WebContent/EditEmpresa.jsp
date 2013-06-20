<%@page import="DAO.DAOEmpresa"%>
<%@page import="entidade.Empresa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Empresa</title>
</head>
<body>
	<%
		Empresa empresa;
		DAOEmpresa daoEmpresa = new DAOEmpresa();
		empresa = daoEmpresa.buscar(Integer.parseInt(request.getParameter("id")));
		
	%>
	<form method="post" action="EditEmpresa">
		<table>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Ação</th>
			</tr>
			<tr>
				<td><%= empresa.getIdEmpresa() %></td>
				<td><input type="text" value="<%= empresa.getNome() %>" name="nome" /> </td>
				<td><input type="submit" value="Alterar" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>