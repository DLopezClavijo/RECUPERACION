package es.altair.springhibernate.dao;

import java.util.List;

import es.altair.springhibernate.bean.Compras;
import es.altair.springhibernate.bean.Libros;
import es.altair.springhibernate.bean.Usuarios;

public interface CompraDAO {
	void insertar(Compras c);
	List<Compras> listarPorUsu(int idUsuario);
	Compras getCompraById(int idCompra);
	void borrar(Compras	c);
}
