package es.altair.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="compras")
 public class Compras implements Serializable{
 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int idCompra; 
	 
	 @Temporal(TemporalType.DATE)
	 private Date fecha;
	 private int cantidad; 
	 private int precio; 
	 
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="idUsuario")
	 private Usuarios usuarios; 
	 
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="idLibro")
	 private Libros libros;

	public Compras() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compras(Date fecha, int cantidad, int precio, Usuarios usuarios, Libros libros) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.precio = precio;
		this.usuarios = usuarios;
		this.libros = libros;
	}

	public int getIdcompras() {
		return idCompra;
	}

	public void setIdcompras(int idComprass) {
		this.idCompra = idComprass;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Usuarios getUsuario() {
		return usuarios;
	}

	public void setUsuario(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Libros getLibro() {
		return libros;
	}

	public void setLibro(Libros libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Compras [idCompra=" + idCompra + ", fecha=" + fecha + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", usuarios=" + usuarios + ", libros=" + libros + "]";
	} 
	 
	 
}
