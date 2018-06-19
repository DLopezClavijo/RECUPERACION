package es.altair.springhibernate.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import es.altair.springhibernate.bean.Libros;
import es.altair.springhibernate.bean.Usuarios;
import es.altair.springhibernate.dao.LibroDAO;
import es.altair.springhibernate.dao.LibroDAOImplHibernate;

@Controller
public class LibrosController {

	@Autowired
	LibroDAO libroDAO;

	@RequestMapping(value = "/borrarLibro", method = RequestMethod.GET)
	public String BorrarLibro(HttpServletRequest request, HttpServletResponse response) {

		String uuid = request.getParameter("uuid");

		Libros libro = libroDAO.obtenerLibroPorUUID(uuid);
		libroDAO.borrar(libro);

		return "redirect:/principalAdmin";
	}

	
	@RequestMapping(value = "/anadirLibroView", method = RequestMethod.GET)
	public ModelAndView anadirLibroView (Model model, @RequestParam(value="mensaje", required=false, defaultValue="") String mensaje) {
		
		model.addAttribute("mensaje", mensaje);
		
		return new ModelAndView("anadirLibro","libro",new Libros());
	}
	
	
	@RequestMapping(value="/anadirLibro", method=RequestMethod.POST)
	public String anadirLibro(@ModelAttribute Libros lib,HttpSession sesion) {
		
		int filas = 0; 
		String mensaje = "";
		
			libroDAO.insertar(lib);
			
			return "redirect:/principalAdmin";

			
	}
	
	@RequestMapping(value = "/editarLibroView", method = RequestMethod.GET)
	public ModelAndView anadirLibroView (Model model, @RequestParam("uuid")String uuid, HttpServletRequest request) {
		System.out.println("ENTRANDO EN EDITAR VIEW");
		String u = request.getParameter("uuid");
		System.out.println("uuid" + u.toString());

		Libros lib = libroDAO.obtenerLibroPorUUID(u);
		
		
		return new ModelAndView("editarLibro","libro",lib);
	}
	
	
	@RequestMapping(value="/editBookView", method = RequestMethod.GET)
	public ModelAndView editBookView (Model model, @RequestParam("uuid")String uuid, HttpServletRequest request) {
		System.out.println("ENTRANDO EN EDITAR VIEW");
		String u = request.getParameter("uuid");
		System.out.println("uuid" + u.toString());

		Libros lib = libroDAO.obtenerLibroPorUUID(u);
		System.out.println(lib.getTitulo());
		
		return new ModelAndView("anadirLibro","libro",lib);
	}
	
	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public ModelAndView  AnadirLibro(HttpServletRequest request, HttpServletResponse response) {
//
//		String uuid = UUID.randomUUID().toString();
//		String titulo = request.getParameter("titulo");
//		String autor = request.getParameter("autor");
//		int isbn = Integer.parseInt(request.getParameter("isbn"));
//		int precio = Integer.parseInt(request.getParameter("precio"));
//		
//
//		HttpSession sesion = request.getSession();
//
//		LibroDAO lDAO = new LibroDAOImplHibernate();
//		Libros l = new Libros(titulo, autor, isbn, null, uuid, precio);
//
//		lDAO.insertar(l);
//		
//		return "redirect:/principalAdmin";
//	}
	
//	@RequestMapping(value = "/editarLibro", method = RequestMethod.POST)
//	public ModelAndView editar() {
//		
//		return new ModelAndView("")
//			
//		}
		
	}


