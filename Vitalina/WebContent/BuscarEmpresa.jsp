<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOEmpresa"%>
<%@page import="entidade.Empresa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
	
	<script  src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>  
    <script  src="js/bootstrap.js"></script>
</head>

<body>
	
	<div class="container">
		<div class="hero-unit">
			<div class="navbar">
			  <div class="navbar-inner">
				  
				<a class="brand" href="#">Toten de Vitalina</a>
				
				<ul class="nav pull-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							Cadastrar <b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">Linha</a></li>
							<li><a href="#">Empresa</a></li>
							<li><a href="#">Local</a></li>
							<li><a href="#">Itinerário</a></li>
							<li><a href="#">Toten</a></li>
						</ul>
					</li>
					<li><a href="#">Sair</a></li>
				</ul>
				
			  </div><!--fim navbar-inner-->
			</div><!--fim navbar-->
			
			<div class="well">

				<form method="post" action="CadastrarEmpresa">
				<fieldset>
					  
					<legend>Cadastro de Empresa</legend>
					<input type="text" placeholder="nome da empresa" name="nome" /><br />

					<button class="btn btn-primary" type="submit" id="salvar">
						<span class="icon-plus-sign icon-white"></span>&nbsp;
						Salvar
					</button>
					
					<button class="btn btn-success" type="submit" id="buscar">
						<span class="icon-plus-sign icon-white"></span>&nbsp;
						Buscar
					</button>
					

				</fieldset>
				</form>
				
				<table class="table table-striped" id="tblempresa">
					<tr>
						<th style="width: 30px;">Id</th>
						<th >Nome</th>
						<th style="width: 50px;">Ação</th>
					</tr>
					
					<%
						ArrayList<Empresa> empresas = new ArrayList<Empresa>();
						DAOEmpresa daoEmpresa = new DAOEmpresa();
						
						empresas = daoEmpresa.buscar(request.getParameter("buscar"));
						
						for (Empresa x : empresas) {
							%>
								<tr>
									<td><%= x.getIdEmpresa() %></td>
									<td><%= x.getNome() %></td>
									<td><a href="EditEmpresa.jsp?id=<%= x.getIdEmpresa()%>">Edit</a></td>
								</tr>
							
							<% 
						}
					%>
					
				</table>
				
			</div>
			<h3 class="pull-right"><small>Toten de Vitalina - SI-IFMA Versão 1.0</small></h3>
		</div><!--fim hero-unit-->
	</div><!--fim container-->
</body>
</html>