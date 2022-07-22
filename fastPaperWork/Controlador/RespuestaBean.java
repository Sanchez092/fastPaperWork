package com.fastPaperWork.Controlador;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.fastPaperWork.DAO.AdministradorDAO;
import com.fastPaperWork.DAO.ProveedorDAO;
import com.fastPaperWork.DAO.RespuestaDAO;
import com.fastPaperWork.model.Administrador;
import com.fastPaperWork.model.Proveedor;
import com.fastPaperWork.model.Respuesta;

import javax.faces.context.FacesContext;

@ManagedBean(name = "respuestaBean")
@RequestScoped
@SessionScoped

public class RespuestaBean {
Respuesta respuesta = new Respuesta();
	
	Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	private int idadministrador;
	private List<Administrador> listAdministrador;
	
	private void llenarAdministrador() {
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		this.listAdministrador = administradorDAO.obtenerAdmin();
	}
		
	public RespuestaBean() {
		this.llenarAdministrador();
	}


	public List<Administrador> getListAdministrador() {
		return listAdministrador;
	}

	public void setListAdministrador(List<Administrador> listAdministrador) {
		this.listAdministrador = listAdministrador;
	}

	public int getIdadministrador() {
		return idadministrador;
	}

	public void setIdadministrador(int idadministrador) {
		this.idadministrador = idadministrador;
	}
	
	
	
	public String nuevo() {
		Respuesta r = new Respuesta();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("respuesta", r);
		return "/vistas/Respuesta/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Respuesta respuesta) {
		RespuestaDAO respuestaDAO = new RespuestaDAO();
	
		AdministradorDAO administradorDAO = new AdministradorDAO();
		Administrador administrador = new Administrador();
		respuesta.setIdadministrador(administrador);
		administrador = administradorDAO.buscar(idadministrador);
		
		respuestaDAO.guardar(respuesta);
		return "/vistas/Respuesta/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Respuesta> obtenerRespuesta(){
		RespuestaDAO respuestaDAO = new RespuestaDAO();
		return respuestaDAO.obtenerRespuesta();
		
	}
	
	public String editar(int idrespuesta) {
		RespuestaDAO respuestaDAO = new RespuestaDAO();
		Respuesta r = new Respuesta();
		r=respuestaDAO.buscar(idrespuesta);
		System.out.println(r);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("respuesta", r);
		return "/vistas/Respuesta/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Respuesta respuesta) {
		 RespuestaDAO respuestaDAO = new RespuestaDAO();
		 respuestaDAO.editar(respuesta);
		 return "/vistas/Respuesta/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idrespuesta) {
		RespuestaDAO respuestaDAO = new RespuestaDAO();
		respuestaDAO.eliminar(idrespuesta);
		System.out.println("Respuesta eliminada..");
		return "/vistas/Respuesta/index.xhtml?faces-redirect=true";
		
	}
	 
}