<%@page import="es.altair.springhibernate.bean.Libros"%>
<%@page import="es.altair.springhibernate.dao.LibroDAOImplHibernate"%>
<%@page import="es.altair.springhibernate.dao.LibroDAO"%>
<%@page import="es.altair.springhibernate.bean.Usuarios"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir Libro</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

</head>
<body>
	<div class="container">

		
		<div class="row">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../index.jsp">Bienvenido
						
				</a></li>
				<li class="breadcrumb-item"><a href="principalAdmin.jsp">Pincipal
						Usuario</a></li>
				<li class="breadcrumb-item">Añadir Libro</li>
				<li class="breadcrumb-item active"><a href="../CerrarSesion">Cerrar
						Sesión</a></li>
			</ol>
		</div>

		<div class="row">
			<div class="col-md-5 col-md-offset-3">
				<div class="form-area">
					<c:url value="/anadirLibro" var="anadir"></c:url>
					<f:form action="${anadir}" method="POST" id="formularioAnadir" commandName="libro"
						enctype="multipart/form-data">
						<h3>Editar Libro</h3>
						<div class="form-group">
							<label for="titulo">Título</label> <input type="text"
								name="titulo" id="titulo" class="form-control">
						</div>
						<div class="form-group">
							<label for="autor">Autor</label> <input type="text" name="autor"
								id="autor" class="form-control">
						</div>
						<div class="form-group">
							<label for="isbn">ISBN</label> <input type="number" name="isbn"
								id="isbn" class="form-control">
						</div>
<!-- 						<div class="form-group"> -->
<!-- 							<label for="portada">Portada</label>  -->
<!-- 							<input type="file" -->
<!-- 								class="form-control" id="portada" name="portada"> -->
<!-- 						</div> -->
						<div class="form-group">
							<label for="precio">Precio</label> <input type="number" name="precio"
								id="precio" class="form-control" required="required">
						</div>
						<div class="form-group">
							<input type="submit" class="form-control btn btn-primary">
						</div>
					</f:form>
				</div>
			</div>
		</div>


		


	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>