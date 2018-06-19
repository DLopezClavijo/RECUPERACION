package es.altair.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import es.altair.bean.Libros;
import es.altair.bean.Usuarios;
import es.altair.dao.LibroDAO;
import es.altair.dao.LibroDAOImplHibernate;

/**
 * Servlet implementation class EditarLibro
 */
@MultipartConfig
public class EditarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarLibro() {
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
		Libros l = null;
		LibroDAO lDAO = null;
		String uuid = null;
		String autor = null;
		String portada = null;
		String titulo = null;
		int isbn = 0;
		int precio = 0;
		
		try {
			uuid = request.getParameter("uuid");
			titulo = request.getParameter("titulo");
			autor = request.getParameter("autor");
			isbn = Integer.parseInt(request.getParameter("isbn"));
			precio = Integer.parseInt(request.getParameter("precio"));
			lDAO = new LibroDAOImplHibernate();
			l = lDAO.obtenerLibroPorUUID(uuid);
			
			
		} catch (Exception e) {
			
		}
		
		
		
		// Tratamiento de la imagen
		Part filePart = request.getPart("portada");
		
		InputStream inputS = null;
		ByteArrayOutputStream os = null;
		if (!getFileName(filePart).equals("")) {
			inputS = filePart.getInputStream();
			
			// Escalar la imagen
			BufferedImage imageBuffer = ImageIO.read(inputS);
			Image tmp = imageBuffer.getScaledInstance(640, 640, BufferedImage.SCALE_FAST);
			BufferedImage buffered = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
			buffered.getGraphics().drawImage(tmp, 0, 0, null);
			
			os = new ByteArrayOutputStream();
			ImageIO.write(buffered, "jpg", os);
			
			l.setPortada(os.toByteArray());
		}
		
		HttpSession sesion = request.getSession();
		
		l.setTitulo(titulo);
		l.setAutor(autor);
		l.setIsbn(isbn);
		l.setPrecio(precio);
		
		lDAO.actualizar(l);
		
		response.sendRedirect("jsp/principalAdmin.jsp");
		
	}
	
	private String getFileName(Part filePart) {
		for(String content : filePart.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=")+1).trim().replace("\"", "");
		}
		return null;
	}
}
