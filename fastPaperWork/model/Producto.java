package com.fastPaperWork.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;





@Entity
@Table(name="producto")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproducto")
	private int idproducto;
	@Column(name="nombre")
	private String nombre;
	@Column(name="categoria")
	private String categoria;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="estado")
	private String estado;
	@Column(name="precio")
	private double precio;
	
	@OneToMany(mappedBy="idproducto")
	List<Venta> listVenta;
	
	@OneToMany(mappedBy="idproducto")
	List<Cotizacion> listCotizacion;
	
	@OneToMany(mappedBy="idproducto")
	List<Inventario> listInventario;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idproveedor", referencedColumnName = "idproveedor")
	private Proveedor idproveedor;
	
	@OneToMany(mappedBy="idproducto")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Pedido_has_producto> listPedido_has_producto;
	
	
	public List<Inventario> getListInventario() {
		return listInventario;
	}
	public void setListInventario(List<Inventario> listInventario) {
		this.listInventario = listInventario;
	}
	public List<Pedido_has_producto> getListPedido_has_producto() {
		return listPedido_has_producto;
	}
	public void setListPedido_has_producto(List<Pedido_has_producto> listPedido_has_producto) {
		this.listPedido_has_producto = listPedido_has_producto;
	}
	public List<Cotizacion> getListCotizacion() {
		return listCotizacion;
	}
	public void setListCotizacion(List<Cotizacion> listCotizacion) {
		this.listCotizacion = listCotizacion;
	}
	public Proveedor getIdproveedor() {
		return idproveedor;
	}
	public List<Venta> getListVenta() {
		return listVenta;
	}
	public void setListVenta(List<Venta> listVenta) {
		this.listVenta = listVenta;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setIdproveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	
	
	
	
	

		
}