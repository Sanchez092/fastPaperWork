package com.fastPaperWork.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="venta")
public class Venta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idventa")
	private int idventa;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="detalle")
	private String detalle;
	@Column(name="total")
	private double total;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idproducto", referencedColumnName = "idproducto")
	private Producto idproducto;
	
	@OneToMany(mappedBy="idventa")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Calificacion> listCalificacion;
	
	
	
	
	public List<Calificacion> getListCalificacion() {
		return listCalificacion;
	}
	public void setListCalificacion(List<Calificacion> listCalificacion) {
		this.listCalificacion = listCalificacion;
	}
	public Producto getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Producto idproducto) {
		this.idproducto = idproducto;
	}
	public int getIdventa() {
		return idventa;
	}
	public void setIdventa(int idventa) {
		this.idventa = idventa;
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
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	
	
	
	
	

	
	

	

	
	
	
}
