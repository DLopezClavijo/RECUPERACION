<%@page import="es.altair.springhibernate.bean.Libros"%>
<%@page import="es.altair.springhibernate.dao.LibroDAOImplHibernate"%>
<%@page import="es.altair.springhibernate.dao.LibroDAO"%>
<%@page import="es.altair.springhibernate.bean.Usuarios"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Libro</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

</head>
<body>
	<div class="container">

		<%
			if (session.getAttribute("usuLogeado") == null || session.isNew()) {
				response.sendRedirect("../index.jsp?mensaje=Inicie sesión");
			} else {
				LibroDAO lDAO = new LibroDAOImplHibernate();
				Libros l = lDAO.obtenerLibroPorUUID(request.getParameter("uuid"));
		%>

		<div class="row">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../index.jsp">Bienvenido
						<%=((Usuarios) session.getAttribute("usuLogeado")).getNombre()%>
				</a></li>
				<li class="breadcrumb-item"><a href="principalUsu.jsp">Pincipal
						Usuario</a></li>
				<li class="breadcrumb-item">Editar Libro</li>
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
		                    <f:label path="titulo">Titulo:</f:label>
		                    <f:input type="text" 
		                        class="form-control" path="titulo" name="titulo" id="titulo" required="required"/>
		                </div>
						
						<div class="form-group">
		                    <f:label path="autor">Autor:</f:label>
		                    <f:input type="text" 
		                        class="form-control" path="autor" name="autor" id="autor" required="required"/>
		                </div>
						
						<div class="form-group">
		                    <f:label path="isbn">ISBN:</f:label>
		                    <f:input type="number" 
		                        class="form-control" path="isbn" name="isbn" id="isbn" required="required"/>
		                </div>
						<div class="form-group">
		                    <f:label path="precio">Precio:</f:label>
		                    <f:input type="number" 
		                        class="form-control" path="precio" name="precio" id="precio" required="required"/>
		                </div>
<!-- 						<div class="form-group"> -->
<!-- 							<label for="portada">Portada</label>  -->
<!-- 							<input type="file" -->
<!-- 								class="form-control" id="portada" name="portada"> -->
<!-- 						</div> -->
						
						<div class="form-group">
							<input type="submit" class="form-control btn btn-primary">
						</div>
					</f:form>
				</div>
			</div>
		</div>


		<%
			}
		%>



	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>