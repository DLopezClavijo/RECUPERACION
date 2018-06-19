package es.altair.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.altair.bean.Usuarios;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImplHibernate;

/**
 * Servlet implementation class ValidarUsuario
 */
public class ValidarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarUsuario() {
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
		String login = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		UsuarioDAO uDAO = new UsuarioDAOImplHibernate();
		
		Usuarios usu = uDAO.comprobarUsuario(login, password);
		if (usu!=null) {
			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuLogeado", usu);
			
			switch (usu.getTipo()) {
			case 0:
				// Usuario Normal
				response.sendRedirect("jsp/principalUsu.jsp");
				break;
			case 1:
				// Administrador
				response.sendRedirect("jsp/principalAdmin.jsp");
				break;

			default:
				break;
			}
			System.out.println(usu);
		} else {
			// Error Usuario
			response.sendRedirect("index.jsp?mensaje=Usuario y/o Password Incorrecto");
		}
	}

}
