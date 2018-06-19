package es.altair.dao;

import java.util.List;

import es.altair.bean.Compras;
import es.altair.bean.Libros;
import es.altair.bean.Usuarios;

public interface CompraDAO {
	void insertar(Compras c);
	List<Compras> listarPorUsu(int idUsuario);
	Compras getCompraById(int idCompra);
	void borrar(Compras	c);
}
