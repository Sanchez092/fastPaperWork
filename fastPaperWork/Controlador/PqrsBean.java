package com.fastPaperWork.Controlador;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fastPaperWork.DAO.ClienteDAO;
import com.fastPaperWork.DAO.PqrsDAO;
import com.fastPaperWork.DAO.RespuestaDAO;
import com.fastPaperWork.model.Cliente;
import com.fastPaperWork.model.Pqrs;
import com.fastPaperWork.model.Respuesta;

@ManagedBean(name = "pqrsBean")
@RequestScoped
@SessionScoped 

public class PqrsBean {
	
	Pqrs pqrs = new Pqrs();
	
	public int idcliente;
	
	public List<Cliente> listaCliente;
	
	public int idrespuesta;
	
	public List<Respuesta> listaRespuesta;
	
	
	public void llenarCliente() {
		ClienteDAO clienteDAO = new ClienteDAO();
		this.listaCliente=clienteDAO.obtenerCliente();
	}
	
	public void llenarRespuesta() {
		RespuestaDAO respuestaDAO = new RespuestaDAO();
		this.listaRespuesta=respuestaDAO.obtenerRespuesta();
	}
	

	public PqrsBean() {
		this.llenarCliente();
		this.llenarRespuesta();
	}
	


	public int getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	


	public int getIdrespuesta() {
		return idrespuesta;
	}

	public void setIdrespuesta(int idrespuesta) {
		this.idrespuesta = idrespuesta;
	}

	public String nuevo() {
		Pqrs p = new Pqrs();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("pqrs", p);
		return "/vistas/Pqrs/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Pqrs pqrs) {
		Date fechaActual = new Date();
		pqrs.setFechaHora(new java.sql.Date(fechaActual.getTime()));
		
		PqrsDAO pqrsDAO =new PqrsDAO();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		pqrs.setIdcliente(cliente);
		cliente=clienteDAO.buscar(idcliente);
		
		RespuestaDAO respuestaDAO = new RespuestaDAO();
		Respuesta respuesta = new Respuesta();
		pqrs.setIdrespuesta(respuesta);
		respuesta=respuestaDAO.buscar(idrespuesta);
		
		pqrsDAO.guardar(pqrs);
		return "/vistas/Pqrs/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Pqrs> obtenerPqrs(){
		PqrsDAO pqrsDAO =new PqrsDAO();
		return pqrsDAO.obtenerPqrs();
	}
	
	public String editar(int idpqrs) {
		PqrsDAO pqrsDAO =new PqrsDAO();
		Pqrs p = new Pqrs();
		p=pqrsDAO.buscar(idpqrs);
		System.out.println(p);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("pqrs", p);
		return "/vistas/Pqrs/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Pqrs pqrs) {
		Date fechaActual = new Date();
		pqrs.setFechaHora(new java.sql.Date(fechaActual.getTime()));
		
		PqrsDAO pqrsDAO = new PqrsDAO();
		pqrsDAO.editar(pqrs);
		return "/vistas/Pqrs/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idpqrs) {
		PqrsDAO pqrsDAO = new PqrsDAO();
		pqrsDAO.eliminar(idpqrs);
		System.out.println("Pqrs eliminada..");
		return "/vistas/Pqrs/index.xhtml?faces-redirect=true";
		
	}
	
}
