package es.altair.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.bean.Usuarios;
import es.altair.util.SessionProvider;

public class UsuarioDAOImplHibernate implements UsuarioDAO {

	private String pass = "Libros123$%";

	public Usuarios comprobarUsuario(String login, String password) {
		Usuarios usu = null;

		// SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// Session sesion = sf.openSession();

        Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			usu = (Usuarios) sesion
					.createQuery("SELECT u FROM Usuarios u WHERE login=:l" + " AND password=AES_ENCRYPT(:p, :passphrase)")
					.setParameter("l", login).setParameter("p", password).setParameter("passphrase", pass)
					.uniqueResult();
			
			

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return usu;
	}

	public int insertar(Usuarios usu) {
		int filas = 0;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			filas = sesion
					.createSQLQuery("INSERT INTO usuarios (login, password, nombre, email, tipo)"
							+ "values (:l, AES_ENCRYPT(:p, :passphrase), :n, :e, :t)")
					.setParameter("l", usu.getLogin()).setParameter("p", usu.getPassword())
					.setParameter("passphrase", pass).setParameter("n", usu.getNombre())
					.setParameter("e", usu.getEmail()).setParameter("t", usu.getTipo()).executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}

		return filas;
	}

	public boolean validarEmail(Usuarios usu) {
		boolean correcto = true;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			if ((Usuarios) sesion.createQuery("From Usuario Where email=:e")
					.setParameter("e", usu.getEmail())
					.uniqueResult() != null)
				correcto = false;

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		return correcto;
	}

	public Usuarios getUsuarioByLogin(String login) {
		
			Usuarios usuario = null;

			Session sesion = SessionProvider.getSession();
			try {
				sesion.beginTransaction();

				usuario = (Usuarios) sesion.createQuery("Select u From Usuarios u Where u.login=:login")
						.setParameter("login", login).uniqueResult();

				sesion.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				sesion.close();
				// sf.close();
			}

			return usuario;
		
	}

}
