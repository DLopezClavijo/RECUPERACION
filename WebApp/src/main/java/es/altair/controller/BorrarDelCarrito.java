package es.altair.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.altair.bean.Compras;
import es.altair.dao.CompraDAO;
import es.altair.dao.CompraDAOImplHibernate;

/**
 * Servlet implementation class BorrarDelCarrito
 */
public class BorrarDelCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarDelCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				System.out.println("Entramos en comprar");
				int idCompra = Integer.parseInt(request.getParameter("idCompra"));

				CompraDAO cDAO = new CompraDAOImplHibernate();
				System.out.println("Vamos a borrar");
				Compras compra = cDAO.getCompraById(idCompra);
				cDAO.borrar(compra); 
				
				System.out.println("Volvemos a la pagina");
				response.sendRedirect("jsp/cesta.jsp");
	}

}
