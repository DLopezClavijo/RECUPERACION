package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.bean.Libros;
import es.altair.bean.Usuarios;
import es.altair.util.SessionProvider;

public class LibroDAOImplHibernate implements LibroDAO {

	public List<Libros> listaLibro() {
		List<Libros> libros = new ArrayList<Libros>();

		Session sesion = SessionProvider.getSession();
		try {
			
			
			libros = sesion.createQuery("FROM Libros l").list();
			//libros = sesion.createQuery("FROM Libro l WHERE usuario=:usu").setParameter("usu", u).list();

			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return libros;
	}

	public byte[] obtenerPortadaPorId(int idLibro) {
		byte[] imagen = null;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			imagen = (byte[]) sesion.createQuery("Select l.portada From Libros l Where l.idLibro=:id")
					.setParameter("id", idLibro).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return imagen;
	}

	public void borrar(Libros l) {
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			
			sesion.delete(l);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}

	public Libros obtenerLibroPorUUID(String uuid) {
		Libros l = new Libros();

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			l = (Libros) sesion.createQuery("FROM Libros l WHERE l.uuid=:clave").setParameter("clave", uuid)
					.uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
		return l;
	}
	

//	public void actualizar(String titulo, String autor, int isbn, ByteArrayOutputStream os, String uuid,Float precio,
//			Usuarios usuario) {
//		Session sesion = SessionProvider.getSession();
//		try {
//			sesion.beginTransaction();
//
//			if (os != null) {
//				sesion.createQuery("UPDATE Libro SET titulo=:t, autor=:a, isbn=:i,precio=:precio " 
//						+ "portada=:p WHERE uuid=:clave")
//						.setParameter("t", titulo)
//						.setParameter("a", autor)
//						.setParameter("i", isbn)
//						.setParameter("p", os.toByteArray())
//						.setParameter("precio", precio)
//						.setParameter("clave", uuid)
//						.executeUpdate();
//			} else {
//				sesion.createQuery("UPDATE Libro SET titulo=:t, autor=:a, isbn=:i,precio=:precio, " 
//						+ " WHERE uuid=:clave")
//						.setParameter("t", titulo)
//						.setParameter("a", autor)
//						.setParameter("i", isbn)
//						.setParameter("precio", precio)
//						.setParameter("clave", uuid)
//						.executeUpdate();
//			}
//
//			sesion.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			sesion.close();
//			// sf.close();
//		}
//	}

	public void insertar(Libros l) {
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.save(l);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}

	public void actualizar(String titulo, String autor, int isbn, float precio, ByteArrayOutputStream os, String uuid,
			Usuarios usuario) {
		
		
	}

	public void actualizar(Libros l) {
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.update(l);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}

}
