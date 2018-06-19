package es.altair.springhibernate.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="libros") 
public class Libros implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibro;
	private String titulo;
	private String autor;
	private int isbn;
	private byte[] portada;
	private String uuid;
	private int precio;

	@OneToMany(mappedBy="libros", cascade=CascadeType.ALL)
	private Set<Compras> compras = new HashSet<Compras>();

	public Libros() {
		// TODO Auto-generated constructor stub
	}

	public Libros(String titulo, String autor, int isbn, byte[] portada, String uuid, int precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.portada = portada;
		this.uuid = uuid;
		this.precio = precio;
	}

	public int getidLibro() {
		return idLibro;
	}

	public void setidLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public byte[] getPortada() {
		return portada;
	}

	public void setPortada(byte[] portada) {
		this.portada = portada;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}



	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", portada="
				+ Arrays.toString(portada) + ", uuid=" + uuid + ", precio=" + precio +"]";
	}

}
