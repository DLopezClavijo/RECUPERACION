<%@page import="java.util.List"%>
<%@page import="es.altair.bean.Usuarios"%>
<%@page import="es.altair.bean.Libros"%>
<%@page import="es.altair.dao.LibroDAOImplHibernate"%>
<%@page import="es.altair.dao.LibroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libros del Usuario</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- Stylesheets -->
<link rel="stylesheet" href="../fonts/font-awesome.min.css">
</head>
<body>
	<div class="container">

		<%
			if (session.getAttribute("usuLogeado") == null || session.isNew()) {
				response.sendRedirect("../index.jsp?mensaje=Inicie sesión");
			} else {
				LibroDAO lDAO = new LibroDAOImplHibernate();
				List<Libros> libros = lDAO.listaLibro();
		%>

		<div class="row">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../index.jsp">Bienvenido 
					<%=((Usuarios)session.getAttribute("usuLogeado")).getNombre()%>
					</a>
				</li>	
				<li class="breadcrumb-item">ADMIN</li>
				<li class="breadcrumb-item active"><a href="../CerrarSesion">Cerrar Sesión</a></li>		
			</ol>
		</div>

		<div class="row col-md-8 col-md-offset-2">
			<table class="table table-striped">
				<thead>
					<a href="anadirLibro.jsp" class="btn btn-primary btn-xs pull-right"><b>+</b>
						Añadir Libro</a>
					<tr>
						<th>Título</th>
						<th>Autor</th>
						<th>ISBN</th>
						<th>Precio</th>
						<th>Portada</th>
						
						<th></th>
					</tr>
				</thead>
				<%
					for (Libros l : libros) {
				%>
				<tr>
					<td><%=l.getTitulo()%></td>
					<td><%=l.getAutor()%></td>
					<td><%=l.getIsbn()%></td>
					<td><%=l.getPrecio()%></td>
					<td><img alt="Portada"
						src="image.jsp?imag=<%=l.getidLibro()%>" class="img-thumbnail"
						width="50" height="50"></td>
					<td>
						<button type="button" class="btn btn-default"
							onclick="location.href='editarLibro.jsp?uuid=<%=l.getUuid()%>'">
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
							Actualizar
						</button> <!-- Button trigger modal -->
						
						<form action="../BorrarLibro" method="post" role="form">

							<input type="text" name="uuid" id="uuid" value="<%=l.getUuid()%>" hidden="hidden">
							<input type="submit" class="form-control btn btn-primary" value="Borrar">
						</form>
						
						<!-- Modal -->					
<%-- 						<div class="modal fade" id="borrarLibro<%=l.getidLibro()%>" --%>
<!-- 							tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" -->
<!-- 							aria-hidden="true"> -->
<!-- 							<div class="modal-dialog" role="document"> -->
<!-- 								<div class="modal-content"> -->
<!-- 									<div class="modal-header"> -->
<!-- 										<h5 class="modal-title" id="exampleModalLabel">Borrar -->
<!-- 											Libro</h5> -->
<!-- 										<button type="button" class="close" data-dismiss="modal" -->
<!-- 											aria-label="Close"> -->
<!-- 											<span aria-hidden="true">&times;</span> -->
<!-- 										</button> -->
<!-- 									</div> -->
<!-- 									<div class="modal-body"> -->
<!-- 										¿Desea borrar el libro -->
<%-- 										<%=l.getTitulo()%>? --%>
<!-- 									</div> -->
<!-- 									<div class="modal-footer"> -->
<!-- 										<button type="button" class="btn btn-secondary" -->
<!-- 											data-dismiss="modal">No</button> -->
<!-- 										<button type="button" class="btn btn-primary" -->
<%-- 											onclick="location.href='../BorrarLibro?uuid=<%=l.getUuid()%>'">Sí</button> --%>
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->

					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>


		<%
			}
		%>



	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>