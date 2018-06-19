<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Web App</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-6">
				<h1>Login</h1>

				<c:if test="${not empty mensaje}">
					<div class="alert alert-warning alert-dismissable">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">x</button>
						<strong>Info!</strong>
						${mensaje}
					</div>
				</c:if>
				
				<hr>
				<c:url value="/ValidarUsuario" var="validar"></c:url>
				<f:form class="navbar-form navbar-right" method="POST"
					action="${validar}" id="validarUsu" commandName="usuario">
					<div class="form-group">
						<f:label path="login">Usuario: </f:label>
						<br>
						<f:input type="text" placeholder="Nombre Usuario"
							class="form-control" path="login" name="login" id="login" required="required"/>
					</div>
					<div class="form-group">
						<f:label path="password">Password:</f:label>
						<f:input type="password" path="password" name="password" id="password"
							placeholder="Password" class="form-control" required="required"/>
					</div>
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-sign-in"></i> Enviar
					</button>
					
				</f:form>
				<button type="button" class="btn btn-warning"
                        onclick="location.href='<c:url value="/registrarView"/>'">
                        <i class="fa fa-car" aria-hidden="true"></i> Editar Coche
                    </button>
				<%-- <input type="button" class="btn btn-default"
					href="<c:url value="/registrarView"/>">
						<i class="fa fa-user-plus"></i> Registrar
					</input> --%>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
