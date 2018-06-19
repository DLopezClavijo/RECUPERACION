package es.altair.springhibernate.dao;

import es.altair.springhibernate.bean.Usuarios;

public interface UsuarioDAO {

	Usuarios comprobarUsuario(String login, String password);
	
	Usuarios getUsuarioByLogin(String login);

	int insertar(Usuarios usu);

	boolean validarEmail(Usuarios usu);

}
