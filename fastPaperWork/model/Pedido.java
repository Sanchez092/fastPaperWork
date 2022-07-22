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
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "pedido")

public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpedido")
	private int idpedido;
	@Column(name="cantidadTotal")
	private int cantidadTotal;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="direccion")
	private String direccion;
	@Column(name="descuento")
	private double descuento;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idcliente", referencedColumnName = "idcliente")
	private Cliente idcliente;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idseguimiento_envio", referencedColumnName = "idseguimiento_envio")
	private SeguimientoEnvio idseguimiento_envio;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idforma_de_pago", referencedColumnName = "idforma_de_pago")
	private Forma_de_pago idforma_de_pago;
	
	@OneToMany(mappedBy="idpedido")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Pedido_has_producto> listPedido_has_producto;
	
	

	public List<Pedido_has_producto> getListPedido_has_producto() {
		return listPedido_has_producto;
	}

	public void setListPedido_has_producto(List<Pedido_has_producto> listPedido_has_producto) {
		this.listPedido_has_producto = listPedido_has_producto;
	}

	public Forma_de_pago getIdforma_de_pago() {
		return idforma_de_pago;
	}

	public void setIdforma_de_pago(Forma_de_pago idforma_de_pago) {
		this.idforma_de_pago = idforma_de_pago;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cliente getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Cliente idcliente) {
		this.idcliente = idcliente;
	}

	public SeguimientoEnvio getIdseguimiento_envio() {
		return idseguimiento_envio;
	}

	public void setIdseguimiento_envio(SeguimientoEnvio idseguimiento_envio) {
		this.idseguimiento_envio = idseguimiento_envio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	
	
}