package com.fastPaperWork.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fastPaperWork.DAO.CalificacionDAO;
import com.fastPaperWork.DAO.ClienteDAO;
import com.fastPaperWork.DAO.VentaDAO;
import com.fastPaperWork.model.Administrador;
import com.fastPaperWork.model.Calificacion;
import com.fastPaperWork.model.Cliente;
import com.fastPaperWork.model.Venta;



@ManagedBean(name = "calificacionBean")
@RequestScoped
@SessionScoped

public class CalificacionBean {
	
	Calificacion calificacion = new Calificacion();
	private List<Calificacion> obtenerCalificacion = new ArrayList<Calificacion>();
	
	
	private int idcliente;
	
	public List<Cliente> listaCliente;
	
	private int idventa;
	
	public List<Venta> listaVenta;
	
	public void llenarCliente() {
		ClienteDAO clienteDAO = new ClienteDAO();
		this.listaCliente=clienteDAO.obtenerCliente();
	}
	
	public void llenarVenta() {
		VentaDAO ventaDAO = new VentaDAO();
		this.listaVenta=ventaDAO.obtenerVenta();
	}
	
	
	public CalificacionBean() {
		this.llenarCliente();
		this.llenarVenta();
	}
	
	

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public String nuevo() {
		Calificacion ca = new Calificacion();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("calificacion", ca);
		return "/vistas/Calificacion/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Calificacion calificacion) {
		CalificacionDAO calificacionDAO = new CalificacionDAO();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		calificacion.setIdcliente(cliente);
		cliente = clienteDAO.buscar(idcliente);
		
		VentaDAO ventaDAO = new VentaDAO();
		Venta venta = new Venta();
		calificacion.setIdventa(venta);
		venta = ventaDAO.buscar(idventa);
		
	    calificacionDAO.guardar(calificacion);
		return "/vistas/Calificacion/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Calificacion> obtenerCalificacion(){
		CalificacionDAO calificacionDAO = new CalificacionDAO();
		return calificacionDAO.obtenerCalificacion();
		
	}
	
	public String editar(int idcalificacion) {
		CalificacionDAO calificacionDAO = new CalificacionDAO();
		Calificacion ca = new Calificacion();
		ca=calificacionDAO.buscar(idcalificacion);
		System.out.println(ca);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("calificacion", ca);
		return "/vistas/Calificacion/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Calificacion calificacion) {
		 CalificacionDAO calificacionDAO = new CalificacionDAO();
		 calificacionDAO.editar(calificacion);
		 return "/vistas/Calificacion/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idcalificacion) {
		CalificacionDAO calificacionDAO = new CalificacionDAO();
		calificacionDAO.eliminar(idcalificacion);
		System.out.println("Calificacion eliminado..");
		return "/vistas/Calificacion/index.xhtml?faces-redirect=true";
		
	}
	 
}