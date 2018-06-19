package es.altair.springhibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.altair.springhibernate.bean.Compras;
import es.altair.springhibernate.bean.Libros;
import es.altair.springhibernate.bean.Usuarios;
import es.altair.springhibernate.util.SessionProvider;

public class CompraDAOImplHibernate implements CompraDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public void insertar(Compras c) {
		Session sesion = sessionFactory.getCurrentSession();
		
	
//		sesion.createSQLQuery("INSERT INTO compra (fecha, cantidad, precio, idUsuario, idLibro) values(:f, :c, :p, :u, :l) ")
//			.setParameter("f", c.getFecha())
//			.setParameter("c", c.getCantidad())
//			.setParameter("p", c.getPrecio())
//				.setParameter("u", c.getUsuario().getIdUsuarios())
//			.setParameter("a", c.getLibro().getidLibro())
//			.executeUpdate();
		
		sesion.save(c);
		sesion.flush();
		
		
	}

	@Transactional
	@Override
	public List<Compras> listarPorUsu(int idUsuario) {
		List<Compras> compras = new ArrayList<Compras>();
		
		Session sesion = sessionFactory.getCurrentSession();
		
		compras = sesion.createQuery("FROM Compras c WHERE idUsuario=:idUsuario")
					.setParameter("idUsuario", idUsuario).list();
				
		return compras;
	}

	@Transactional
	@Override
	public void borrar(Compras c) {
		Session sesion = sessionFactory.getCurrentSession();
		
			sesion.merge(c);
			sesion.delete(c);
				
		
	}
	
	@Transactional
	@Override
	public Compras getCompraById(int idCompra) {
		Compras compra = null;

		Session sesion = sessionFactory.getCurrentSession();

		compra = (Compras) sesion.createQuery("From Compras c Where idCompra=:idCompra")
				.setParameter("idCompra", idCompra).uniqueResult();

		

		return compra;
	}

}
