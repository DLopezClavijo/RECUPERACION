package es.altair.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.altair.bean.Compras;
import es.altair.bean.Libros;
import es.altair.bean.Usuarios;
import es.altair.dao.CompraDAO;
import es.altair.dao.CompraDAOImplHibernate;
import es.altair.dao.LibroDAO;
import es.altair.dao.LibroDAOImplHibernate;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImplHibernate;

/**
 * Servlet implementation class AnadirAlCarrito
 */
public class AnadirAlCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirAlCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		java.util.Date fecha = new Date();
		Date fechaR = fecha; 
		System.out.println(fechaR);
		
		int cantidad = 1; 
		int precio1 = 12;

		String uuid = request.getParameter("uuid");
		System.out.println(uuid);
		LibroDAO lDAO = new LibroDAOImplHibernate();
		UsuarioDAO uDAO = new UsuarioDAOImplHibernate();
		Libros l = lDAO.obtenerLibroPorUUID(uuid);
		System.out.println("Libro: "+ l.getTitulo());
		
		HttpSession sesion = request.getSession();		
		System.out.println("Usuario: "+ sesion.getAttribute("usuLogeado"));
		
			
		CompraDAO cDAO = new CompraDAOImplHibernate(); 
//		Usuarios u = (Usuarios) sesion.getAttribute("usuLogeado");
		
		Compras c = new Compras(fechaR, cantidad, precio1,(Usuarios) sesion.getAttribute("usuLogeado"), l);
		System.out.println("Usuario: "+c.getUsuario().toString());
		cDAO.insertar(c);
		
		response.sendRedirect("jsp/principalUsu.jsp");
	}

}
