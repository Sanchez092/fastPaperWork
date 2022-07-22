package com.fastPaperWork.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cotizacion")

public class Cotizacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcotizacion")
	private int idcotizacion;
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name="total")
	private double total;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idproducto", referencedColumnName = "idproducto")
	private Producto idproducto;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idadministrador", referencedColumnName = "idAdministrador")
	private Administrador idadministrador;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idcliente", referencedColumnName = "idcliente")
	private Cliente idcliente;
	
	
	
	
	public Cliente getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Cliente idcliente) {
		this.idcliente = idcliente;
	}
	public Producto getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Producto idproducto) {
		this.idproducto = idproducto;
	}
	public Administrador getIdadministrador() {
		return idadministrador;
	}
	public void setIdadministrador(Administrador idadministrador) {
		this.idadministrador = idadministrador;
	}
	public int getIdcotizacion() {
		return idcotizacion;
	}
	public void setIdcotizacion(int idcotizacion) {
		this.idcotizacion = idcotizacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	@Override
	public String toString() {
		return "Cotizacion [idcotizacion=" + idcotizacion + 
				", fecha=" + fecha + ", total=" + total + "]";
	}
	public Cotizacion(int idcotizacion, Date fecha, double total) {
	super();
	this.idcotizacion = idcotizacion;
	this.fecha = fecha;
	this.total = total;
	}
	public Cotizacion() {
		super();
	}
	
	
}
