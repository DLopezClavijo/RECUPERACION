package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import es.altair.bean.Libros;
import es.altair.bean.Usuarios;

public interface LibroDAO {

	List<Libros> listaLibro();
	
	byte[] obtenerPortadaPorId(int idLibro);

	void borrar(Libros l);
	
	Libros obtenerLibroPorUUID(String uuid);

	void actualizar(Libros l);

	void insertar(Libros l);
}
