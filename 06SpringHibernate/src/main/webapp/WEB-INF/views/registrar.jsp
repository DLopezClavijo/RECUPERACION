<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- Stylesheets -->
<link rel="stylesheet" href="../fonts/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Registro</h1>
				<%
					String error = request.getParameter("mensaje");
					if (error != null) {
				%>
				<div class="alert alert-warning alert-dismissable">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">x</button>
					<strong>Info!</strong>
					<%=error%>
				</div>
				<%
					}
				%>
				<hr>
				<c:url value="/registrar" var="registrar"></c:url>
				<f:form  class="form-horizontal" method="POST"
				action="${registrar}" id="formularioRegistrar" commnadName="usuario">
					<div class="form-group">
						<label class="col-md-6 control-label" for="login">Login</label>
						<div class="col-md-6">
							<input type="text" id="login" name="login" placeholder="Login"
								class="form-control input-md" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-6 control-label" for="password">Password</label>
						<div class="col-md-6">
							<input type="password" id="password" name="password" placeholder="Password"
								class="form-control input-md" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-6 control-label" for="nombre">Nombre</label>
						<div class="col-md-6">
							<input type="text" id="nombre" name="nombre" placeholder="Nombre"
								class="form-control input-md" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-6 control-label" for="email">Email</label>
						<div class="col-md-6">
							<input type="email" id="email" name="email" placeholder="Email"
								class="form-control input-md" required>
						</div>
					</div>
					<button type="submit" class="btn btn-secondary">
                    	<i class="fa fa-floppy-o" aria-hidden="true"></i>Guardar
                	</button>
				</f:form>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>