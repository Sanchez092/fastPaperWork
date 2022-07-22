package com.fastPaperWork.Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.fastPaperWork.DAO.AdministradorDAO;
import com.fastPaperWork.DAO.ClienteDAO;
import com.fastPaperWork.DAO.CotizacionDAO;
import com.fastPaperWork.DAO.ProductoDAO;
import com.fastPaperWork.model.Administrador;
import com.fastPaperWork.model.Cliente;
import com.fastPaperWork.model.Cotizacion;
import com.fastPaperWork.model.Producto;

import javax.faces.context.FacesContext;

@ManagedBean(name = "cotizacionBean")
@RequestScoped
@SessionScoped

public class CotizacionBean {
	
	Cotizacion cotizacion = new Cotizacion();
	private List<Cotizacion> obtenerCotizacion = new ArrayList<Cotizacion>();
	
	private int idproducto;
	
	public List<Producto> listaProductos;
	
	private int idadministrador;
	
	public List<Administrador> listaAdministrador;
	
	public int idcliente;
	
	public List<Cliente> listaCliente;
	
	public void llenarProducto() {
		ProductoDAO productoDAO = new ProductoDAO();
		this.listaProductos=productoDAO.obtenerProducto();
	}
	
	public void llenarAdministrador() {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		this.listaAdministrador=administradorDAO.obtenerAdmin();
	}
	
	public void llenarCliente() {
		ClienteDAO clienteDAO = new ClienteDAO();
		this.listaCliente=clienteDAO.obtenerCliente();
	}
	
	public CotizacionBean() {
		this.llenarProducto();
		this.llenarAdministrador();
		this.llenarCliente();
	}
	

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getIdadministrador() {
		return idadministrador;
	}

	public void setIdadministrador(int idadministrador) {
		this.idadministrador = idadministrador;
	}

	public String nuevo() {
		Cotizacion c = new Cotizacion();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cotizacion", c);
		return "/vistas/Cotizacion/add.xhtml?faces-redirect=true";		
	}
	
	public String guardar(Cotizacion cotizacion) {
		Date fechaActual = new Date();
		cotizacion.setFecha(new java.sql.Date(fechaActual.getTime()));
		
		CotizacionDAO cotizacionDAO = new CotizacionDAO();
		ProductoDAO productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		cotizacion.setIdproducto(producto);
		producto = productoDAO.buscar(idproducto);
		
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		Administrador administrador = new Administrador();
		cotizacion.setIdadministrador(administrador);
		administrador = administradorDAO.buscar(idadministrador);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		cotizacion.setIdcliente(cliente);
		cliente=clienteDAO.buscar(idcliente);
		
		
		
		cotizacionDAO.guardar(cotizacion);
		return "/vistas/Cotizacion/index.xhtml?faces-redirect=true";
	}
	
	public List<Cotizacion> obtenerCotizacion(){
		CotizacionDAO cotizacionDAO = new CotizacionDAO();
		return cotizacionDAO.obtenerCotizacion();
	}
	
	public String editar(int idcotizacion) {
		CotizacionDAO cotizacionDAO = new CotizacionDAO();
		Cotizacion c = new Cotizacion();
		c=cotizacionDAO.buscar(idcotizacion);
		System.out.println(c);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cotizacion", c);
		return "/vistas/Cotizacion/editar.xhtml?faces-redirect=true"; 
	}
	
	public String actualizar(Cotizacion cotizacion) {
		Date fechaActual = new Date();
		cotizacion.setFecha(new java.sql.Date(fechaActual.getTime()));
		
		CotizacionDAO cotizacionDAO = new CotizacionDAO();
		cotizacionDAO.editar(cotizacion);
		return "/vistas/Cotizacion/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idcotizacion) {
		CotizacionDAO cotizacionDAO = new CotizacionDAO();
		cotizacionDAO.eliminar(idcotizacion);
		System.out.println("Cotizacion eliminado..");
		return "/vistas/Cotizacion/index.xhtml?faces-redirect=true";
	}
}
