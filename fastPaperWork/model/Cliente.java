package com.fastPaperWork.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcliente")
	private int idcliente;
	@Column(name="edad")
	private int edad;
	
	
	
	@OneToMany(mappedBy="idcliente")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Cotizacion> listCotizacion;
	
	@OneToMany(mappedBy="idcliente")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Calificacion> listCalificacion;
	
	@OneToMany(mappedBy="idcliente")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Pedido> listPedido;
	
	@OneToMany(mappedBy="idcliente")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Pqrs> listPqrs;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idusuario", referencedColumnName = "idusuario")
	private Usuario idusuario;
	
	
	

	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

	public List<Pqrs> getListPqrs() {
		return listPqrs;
	}

	public void setListPqrs(List<Pqrs> listPqrs) {
		this.listPqrs = listPqrs;
	}

	public List<Pedido> getListPedido() {
		return listPedido;
	}

	public void setListPedido(List<Pedido> listPedido) {
		this.listPedido = listPedido;
	}

	public List<Calificacion> getListCalificacion() {
		return listCalificacion;
	}

	public void setListCalificacion(List<Calificacion> listCalificacion) {
		this.listCalificacion = listCalificacion;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Cotizacion> getListCotizacion() {
		return listCotizacion;
	}

	public void setListCotizacion(List<Cotizacion> listCotizacion) {
		this.listCotizacion = listCotizacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}