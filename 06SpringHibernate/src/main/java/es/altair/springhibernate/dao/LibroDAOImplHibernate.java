package es.altair.springhibernate.dao;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.altair.springhibernate.bean.Libros;
import es.altair.springhibernate.bean.Usuarios;
import es.altair.springhibernate.util.SessionProvider;

public class LibroDAOImplHibernate implements LibroDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public List<Libros> listaLibro() {
		List<Libros> libros = new ArrayList<Libros>();

		Session sesion = sessionFactory.getCurrentSession();
		
			
			libros = sesion.createQuery("FROM Libros l").list();
			//libros = sesion.createQuery("FROM Libro l WHERE usuario=:usu").setParameter("usu", u).list();
		

		return libros;
	}

	@Transactional
	@Override
	public byte[] obtenerPortadaPorId(int idLibro) {
		byte[] imagen = null;

		Session sesion = sessionFactory.getCurrentSession();
				
			imagen = (byte[]) sesion.createQuery("Select l.portada From Libros l Where l.idLibro=:id")
					.setParameter("id", idLibro).uniqueResult();	

		return imagen;
	}

	@Transactional
	@Override
	public void borrar(Libros l) {
		Session sesion = sessionFactory.getCurrentSession();
		
			sesion.delete(l);
		
		
	}

	@Transactional
	@Override
	public Libros obtenerLibroPorUUID(String uuid) {
		System.out.println("ENTRANDO EN obtener");
		System.out.println(uuid);
		Libros l = null;

		Session sesion = sessionFactory.getCurrentSession();
		
			l = (Libros) sesion.createQuery("FROM Libros WHERE uuid=:u").setParameter("u", uuid)
					.uniqueResult();
			System.out.println(l.getTitulo());
		return l;
	}

	@Transactional
	@Override
	public void actualizar(Libros l) {
		// TODO Auto-generated method stub
		
		Session sesion = sessionFactory.getCurrentSession();
		sesion.update(l);
	}

	@Transactional
	@Override
	public void insertar(Libros l) {
		
		Session sesion = sessionFactory.getCurrentSession();
		sesion.save(l);
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


}
