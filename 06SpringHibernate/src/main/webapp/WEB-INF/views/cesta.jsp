<%@page import="es.altair.springhibernate.bean.Compras"%>
<%@page import="es.altair.springhibernate.dao.CompraDAO"%>
<%@page import="es.altair.springhibernate.dao.CompraDAOImplHibernate"%>
<%@page import="es.altair.springhibernate.bean.Usuarios"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mis Compras</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<!-- Stylesheets -->
<link rel="stylesheet" href="../fonts/font-awesome.min.css">

<link href="../css/1-col-portfolio.css" rel="stylesheet">

</head>
<body>

	
		<div class="container">

		<% if(session.getAttribute("usuLogeado") == null || session.isNew())
		{
			response.sendRedirect("../index.jsp?mensaje=Inicie sesión)");
		} else{
// 			String login = ((Usuarios)session.getAttribute("usuLogeado")).getLogin();
			
			CompraDAO cDAO = new CompraDAOImplHibernate();
			Usuarios usuario = (Usuarios)session.getAttribute("usuLogeado");
			System.out.println(usuario.toString());
			List<Compras> listCompra = cDAO.listarPorUsu(usuario.getIdUsuarios());
			System.out.println(listCompra.size());
			for (Compras c : listCompra){
				System.out.println(c.toString());
			}
		%>
		
		<br>
		
			<div class="row col-md-8 col-md-offset-2">
				<table class="table table-striped">
					<h1 class="my-4">Historial de compras</h1>
					
					<thead>
						<tr>
							<th>Portada</th>
							<th>Fecha</th>
							<th>Precio</th>
							<th>Libro</th>
							<th></th>
						</tr>
					</thead>
					
					<%
						for (Compras c : listCompra){
					%>
						<tr>
							<td><img alt="Portada"
								src="image.jsp?imag=<%=c.getLibro().getidLibro()%>"
								class="img-thumbnail" width="150" height="150"></td>
							
							<td><%=c.getFecha()%></td>
							<td><%=c.getPrecio() %></td>
							<td><%=c.getLibro().getTitulo() %></td>
							<td>
							
<!-- 							<button type="button" class="btn btn-warning" data-toggle="modal" -->
<%-- 							data-target="#borrarCompra<%=c.getIdcompras()%>"> --%>
<!-- 							<i class="fa fa-times" aria-hidden="true"></i> Borrar -->
<!-- 							</button> -->

<!-- 							<form action="../BorrarDelCarrito" method="post" role="form"> -->
<%-- 								<input type="text" name="idCompra" id="idCompra" value="<%=c.getIdcompras()%>" hidden="hidden"> --%>
<!-- 								<input type="submit" class="form-control btn btn-primary" value="Borrar"> -->
<!-- 							</form> -->
							
<%-- 							<div class="modal fade" id="borrarCompra<%=c.getIdcompras()%>" --%>
<!-- 							tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" -->
<!-- 							aria-hidden="true"> -->
<!-- 							<div class="modal-dialog" role="document"> -->
<!-- 								<div class="modal-content"> -->
<!-- 									<div class="modal-header"> -->
<!-- 										<h5 class="modal-title" id="exampleModalLabel">Borrar -->
<!-- 											Compra</h5> -->
<!-- 										<button type="button" class="close" data-dismiss="modal" -->
<!-- 											aria-label="Close"> -->
<!-- 											<span aria-hidden="true">&times;</span> -->
<!-- 										</button> -->
<!-- 									</div> -->
<!-- 									<div class="modal-body"> -->
<!-- 										¿Desea borrar la compra del -->
<%-- 										<%=c.getLibro().getTitulo()%>? --%>
<!-- 									</div> -->
<!-- 									<div class="modal-footer"> -->
<!-- 										<button type="button" class="btn btn-secondary" -->
<!-- 											data-dismiss="modal">No</button> -->
<!-- 										<button type="button" class="btn btn-primary" -->
<%-- 											onclick="location.href='../BorrarCompra?id=<%=c.getIdcompras()%>'">Sí</button> --%>
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
							<%
							}
							%>
							
							</td>
						</tr>
						
				</table>
			</div>
			
		<%
		}
		%>
		
		</div>
				<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script src="../js/jquery-3.2.1.slim.min.js"></script>
		<script src="../js/popper.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
</body>
</html>