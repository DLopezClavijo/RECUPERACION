<%@page import="java.util.List"%>
<%@page import="es.altair.springhibernate.bean.Usuarios"%>
<%@page import="es.altair.springhibernate.bean.Libros"%>
<%@page import="es.altair.springhibernate.dao.LibroDAOImplHibernate"%>
<%@page import="es.altair.springhibernate.dao.LibroDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libros del Usuario</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
	<div class="container">

		

		<div class="row">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../index.jsp">Bienvenido 
					
					</a>
				</li>	
				<li class="breadcrumb-item">Usuario</li>
				<li class="breadcrumb-item active"><a href="../CerrarSesion">Cerrar Sesión</a></li>	
				<li class="nav-item"><a class="nav-link" href="cesta.jsp">Historial de Compras</a></li>
			</ol>
			
		</div>

		<div class="row col-md-8 col-md-offset-2">
			<table class="table table-striped">
				<thead>
				
					<tr>
						<th>Título</th>
						<th>Autor</th>
						<th>ISBN</th>				
						<th>Portada</th>
						<th>Precio </th>
						
						<th></th>
					</tr>
				</thead>
		
				<c:forEach items ="${libros}" var="l" varStatus="cont">
					<tr>
						<td>${l.titulo}</td>
						<td>${l.autor}</td>
						<td>${l.isbn}</td>
						<td><img alt="Portada"
							src="image.jsp?imag=${l.idLibro}" class="img-thumbnail"
							width="50" height="50"></td>
						<td>${l.precio}</td>
						
						<td>
							<f:form action="../AnadirAlCarrito" method="post" role="form">
	
								<input type="text" name="uuid" id="uuid" value="{l.uuid}" hidden="hidden">
								<input type="submit" class="form-control btn btn-success" value="Comprar">
							</f:form>
	
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>


	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>