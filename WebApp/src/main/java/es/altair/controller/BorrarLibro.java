package es.altair.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.altair.bean.Libros;
import es.altair.dao.LibroDAO;
import es.altair.dao.LibroDAOImplHibernate;

/**
 * Servlet implementation class BorrarLibro
 */
public class BorrarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarLibro() {
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
String uuid = request.getParameter("uuid");
		
		LibroDAO lDAO = new LibroDAOImplHibernate();
		Libros l = lDAO.obtenerLibroPorUUID(uuid);
		lDAO.borrar(l);
		
		response.sendRedirect("jsp/principalAdmin.jsp");
	}

}
