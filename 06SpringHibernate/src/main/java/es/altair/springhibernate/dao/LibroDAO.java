package es.altair.springhibernate.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import es.altair.springhibernate.bean.Libros;
import es.altair.springhibernate.bean.Usuarios;

public interface LibroDAO {

	List<Libros> listaLibro();
	
	byte[] obtenerPortadaPorId(int idLibro);

	void borrar(Libros l);
	
	Libros obtenerLibroPorUUID(String uuid);

	void actualizar(Libros l);

	void insertar(Libros l);
}
