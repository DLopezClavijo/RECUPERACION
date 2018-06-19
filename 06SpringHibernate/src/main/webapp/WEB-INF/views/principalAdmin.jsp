<%@page import="java.util.List"%>
<%@page import="es.altair.springhibernate.bean.Usuarios"%>
<%@page import="es.altair.springhibernate.bean.Libros"%>
<%@page import="es.altair.springhibernate.dao.LibroDAOImplHibernate"%>
<%@page import="es.altair.springhibernate.dao.LibroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libros del Usuario</title>
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
					
					</a>
				</li>	
				<li class="breadcrumb-item">ADMIN</li>
				<li class="breadcrumb-item active"><a href="../CerrarSesion">Cerrar Sesión</a></li>		
			</ol>
		</div>

		<div class="row col-md-8 col-md-offset-2">
			<table class="table table-striped">
				<thead>
<%-- 					<a href="<c:url" value="/anadirLibroView"></c:url> --%>
<!-- 					 class="btn btn-primary btn-xs pull-right"><b></b> -->
					 
					<button type="button" class="btn btn-success btn-block "
                                onclick="location.href='<c:url value="/anadirLibroView"/>'">
                                <i class="fa fa-user-plus"></i>Añadir Libro
                            </button>
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
				<c:forEach items ="${libros}" var="l" varStatus="cont">
				<tr>
					<td>${l.titulo}</td>
					<td>${l.autor}</td>
					<td>${l.isbn}</td>
					<td>${l.precio}</td>
					<td><img alt="Portada"
						src="image.jsp?imag=${l.idLibro}" class="img-thumbnail"
						width="50" height="50"></td>
					<td>
 						
						
						<button type="button" class="btn btn-default"
							onclick="location.href='/editBookView?uuid=${l.uuid}'">
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
							Editar
						</button>
						<button type="button" class="btn btn-warning"
                        onclick="location.href='<c:url value="/editBookView?uuid=${l.uuid}"/>'">
                        <i class="fa fa-car" aria-hidden="true"></i> Editar Coche
                    </button>
                  			  
                  			  
 
						
						<button type="button" class="btn btn-default"
							onclick="location.href='borrarLibro?uuid=${l.uuid}'">
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
							Borrar
						</button> <!-- Button trigger modal -->
						
					
						
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
				</c:forEach>
			</table>
		</div>



	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery-3.2.1.slim.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>