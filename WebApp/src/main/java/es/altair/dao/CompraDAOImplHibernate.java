package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.bean.Compras;
import es.altair.bean.Libros;
import es.altair.bean.Usuarios;
import es.altair.util.SessionProvider;

public class CompraDAOImplHibernate implements CompraDAO {

	public void insertar(Compras c) {
		Session sesion = SessionProvider.getSession();
		
		try {
		System.out.println("entramos en try ");
		sesion.beginTransaction();
		System.out.println("antes de guardar");
//		sesion.createSQLQuery("INSERT INTO compra (fecha, cantidad, precio, idUsuario, idLibro) values(:f, :c, :p, :u, :l) ")
//			.setParameter("f", c.getFecha())
//			.setParameter("c", c.getCantidad())
//			.setParameter("p", c.getPrecio())
//				.setParameter("u", c.getUsuario().getIdUsuarios())
//			.setParameter("a", c.getLibro().getidLibro())
//			.executeUpdate();
		
		sesion.save(c);
		System.out.println("despues de guardar");
		sesion.flush();
		sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
		}
		
	}

	public List<Compras> listarPorUsu(int idUsuario) {
		List<Compras> compras = new ArrayList<Compras>();
		
		Session sesion = SessionProvider.getSession();
		// System.out.println("entramos en try ");
		sesion.beginTransaction();
		System.out.println("antes de guardar");

		compras = sesion.createQuery("FROM Compras c WHERE idUsuario=:idUsuario")
					.setParameter("idUsuario", idUsuario).list();
		
		System.out.println("despues de guardar");
		sesion.getTransaction().commit();

		sesion.close();

		return compras;
	}

	public void borrar(Compras c) {
		Session sesion = SessionProvider.getSession();
		
			sesion.beginTransaction();
			
//			sesion.createQuery("DELETE FROM Compra WHERE idcompra=:clave")
//					.setParameter("clave", idLibro)
//					.executeUpdate();
			sesion.merge(c);
			sesion.delete(c);
			
			sesion.getTransaction().commit();
		
			sesion.close();

		
	}
	
	public Compras getCompraById(int idCompra) {
		Compras compra = null;

		Session sesion = SessionProvider.getSession();

		sesion.beginTransaction();

		compra = (Compras) sesion.createQuery("From Compras c Where idCompra=:idCompra")
				.setParameter("idCompra", idCompra).uniqueResult();

		sesion.getTransaction().commit();
	
		sesion.close();


		return compra;
	}

}
