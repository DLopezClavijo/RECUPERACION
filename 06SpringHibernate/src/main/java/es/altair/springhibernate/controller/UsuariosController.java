package es.altair.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import es.altair.springhibernate.bean.Usuarios;
import es.altair.springhibernate.dao.LibroDAO;
import es.altair.springhibernate.dao.UsuarioDAO;

@Controller
public class UsuariosController {

	@Autowired	
	LibroDAO libroDAO;
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@RequestMapping(value = "/principalUsu", method = RequestMethod.GET)
	public String principalUsu (Model model) {
				
		model.addAttribute("libros", libroDAO.listaLibro());
		
		return "/principalUsu";
	}

	@RequestMapping(value = "/principalAdmin", method = RequestMethod.GET)
	public String principalAdmin (Model model) {
				
		model.addAttribute("libros", libroDAO.listaLibro());
		
		return "/principalAdmin";
	}
	
	@RequestMapping(value="/registrarView", method = RequestMethod.GET)
	public ModelAndView registrarView () {
		return new  ModelAndView("registrar", "usuario", new Usuarios());  
	}
	
//	@RequestMapping(value="/registrar", method=RequestMethod.POST)
//	public String registrarUsuario(@ModelAttribute Usuarios Usu) {
//		System.out.println("REGISTRAR");
//		int filas = 0; 
//		String mensaje = ""; 
//		if(!usuarioDAO.comprobarUsuario()) {
//			filas = usuarioDAO.insertar(Usu);
//			if(filas == 1) {
//				mensaje="Usuario Registrado"; 
//				return "redirect:/?mensaje="+ mensaje; 
//			}else {
//				mensaje="No se ha registrado al usuario"; 
//				return "redirect:/?mensaje="+ mensaje; 
//			}
//		}else {
//			mensaje="Usuario ya se encuentra registrado"; 
//			return "redirect:/?mensaje="+ mensaje; 
//		}
//	
//	}
}
