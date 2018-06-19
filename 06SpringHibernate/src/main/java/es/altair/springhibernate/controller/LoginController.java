package es.altair.springhibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.altair.springhibernate.bean.Usuarios;
import es.altair.springhibernate.dao.UsuarioDAOImplHibernate;
import es.altair.springhibernate.dao.UsuarioDAO;

@Controller
public class LoginController {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home () {
				
		return "index";
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home (Model model, @RequestParam(value="mensaje", required=false, defaultValue="") String mensaje) {
		
		model.addAttribute("mensaje", mensaje);
		
		return new ModelAndView("index","usuario",new Usuarios());
	}
	
	@RequestMapping(value = "/ValidarUsuario", method = RequestMethod.POST)
	public String validarUsuario (@ModelAttribute Usuarios usu, HttpSession sesion) {
		System.out.println("usu: "+ usu.getLogin());
		Usuarios u = usuarioDAO.comprobarUsuario(usu.getLogin(), usu.getPassword());
		System.out.println(usu);
		System.out.println("Dentro Validar usu");
		if(u != null) {
			sesion.setAttribute("usuarioLogeado", u);
			sesion.setAttribute("tipoUsuario", u.getTipo());
			sesion.setAttribute("idUsuario", u.getIdUsuarios());
			if(u.getTipo() == 1) 
				
				return "redirect:/principalAdmin";
			else 				
				return "redirect:/principalUsu";
			
		}else {
			String mensaje="Usuario y/o Password Incorrecto"; 
			
			return "redirect:/?mensaje=" + mensaje;
		}
		
		}
//		String login = request.getParameter("usuario");
//		String password = request.getParameter("password");
//				
//		boolean usu = usuarioDAO.comprobarUsuario(login, password);
//		
//		if (usu!=null) {
//			
//			HttpSession sesion = request.getSession();
//			sesion.setAttribute("usuLogeado", usu);
//			
//			switch (usu.getTipo()) {
//			case 0:
//				// Usuario Normal
//				return new ModelAndView("redirect:/principalUsu", "", "");
//			case 1:
//				// Administrador
//				return new ModelAndView("redirect:/principalAdmin", "", "");
//
//			}
//			System.out.println(usu);
//		} else {
//			// Error Usuario
//			return new ModelAndView("/index", "mensaje", "Usuario y/o Password Incorrecto");
//		}
//		
//		return new ModelAndView("/index", "", "");
//	}
	

	}

