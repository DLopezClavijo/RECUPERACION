package es.altair.springhibernate.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.springhibernate.bean.Usuarios;
import es.altair.springhibernate.util.SessionProvider;

public class UsuarioDAOImplHibernate implements UsuarioDAO {

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private String pass = "Libros123$%";

	@Transactional
	@Override
	public Usuarios comprobarUsuario(String login, String password) {
		boolean correcto = false;
		
//		Usuarios usu = null;
        Session sesion = sessionFactory.getCurrentSession();
        
		Usuarios u =(Usuarios) sesion.createQuery("SELECT u FROM Usuarios u WHERE login=:l" + " AND password=AES_ENCRYPT(:p, :passphrase)")
					.setParameter("l", login).setParameter("p", password).setParameter("passphrase", pass)
					.uniqueResult();
		System.out.println("DAO IMPLEMENT");
		
		
		return u;
	}

	@Transactional
	@Override
	public int insertar(Usuarios usu) {
		int filas = 0;

		Session sesion = sessionFactory.getCurrentSession();

		filas = sesion
					.createSQLQuery("INSERT INTO usuarios (login, password, nombre, email, tipo)"
							+ "values (:l, AES_ENCRYPT(:p, :passphrase), :n, :e, :t)")
					.setParameter("l", usu.getLogin()).setParameter("p", usu.getPassword())
					.setParameter("passphrase", pass).setParameter("n", usu.getNombre())
					.setParameter("e", usu.getEmail()).setParameter("t", usu.getTipo()).executeUpdate();

		return filas;
	}
	
	

	@Transactional
	@Override
	public boolean validarEmail(Usuarios usu) {
		
		boolean correcto = true;

		Session sesion = sessionFactory.getCurrentSession();
		if ((Usuarios) sesion.createQuery("From Usuario Where email=:e")
					.setParameter("e", usu.getEmail())
					.uniqueResult() != null)
				correcto = false;

		return correcto;
	}

	@Transactional
	@Override
	public Usuarios getUsuarioByLogin(String login) {
		
			Usuarios usuario = null;

			Session sesion = sessionFactory.getCurrentSession();
			usuario = (Usuarios) sesion.createQuery("Select u From Usuarios u Where u.login=:login")
						.setParameter("login", login).uniqueResult();

			return usuario;
		
	}



}
