package com.fastPaperWork.Controlador;


import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import com.fastPaperWork.DAO.SeguimientoEnvioDAO;
import com.fastPaperWork.model.SeguimientoEnvio;


import javax.faces.context.FacesContext;

@ManagedBean(name = "seguimientoEnvioBean")
@RequestScoped
@SessionScoped


public class SeguimientoEnvioBean {
	
	public String nuevo() {
		SeguimientoEnvio s = new SeguimientoEnvio();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("seguimientoEnvio", s);
		return "/vistas/Seguimiento/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(SeguimientoEnvio seguimientoEnvio) {		
		SeguimientoEnvioDAO seguimientoEnvioDAO = new SeguimientoEnvioDAO();
		seguimientoEnvioDAO.guardar(seguimientoEnvio);
		return "/vistas/Seguimiento/index.xhtml?faces-redirect=true";	
	}
	
	public List<SeguimientoEnvio> obtenerSeguimientoEnvio(){
		SeguimientoEnvioDAO seguimientoEnvioDAO = new SeguimientoEnvioDAO();
		return seguimientoEnvioDAO.obtenerSeguimientoEnvio();
		
	}
	
	public String editar(int idseguimiento_envio) {
		SeguimientoEnvioDAO seguimientoEnvioDAO = new SeguimientoEnvioDAO();
		SeguimientoEnvio s = new SeguimientoEnvio();
		s=seguimientoEnvioDAO.buscar(idseguimiento_envio);
		System.out.println(s);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("seguimientoEnvio", s);
		return "/vistas/Seguimiento/editar.xhtml?faces-redirect=true";	
	}
	
	public String actualizar(SeguimientoEnvio seguimientoEnvio) {
		SeguimientoEnvioDAO seguimientoEnvioDAO = new SeguimientoEnvioDAO();
		seguimientoEnvioDAO.editar(seguimientoEnvio);
		return "/vistas/Seguimiento/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idseguimiento_envio) {
		SeguimientoEnvioDAO seguimientoEnvioDAO = new SeguimientoEnvioDAO();
		seguimientoEnvioDAO.eliminar(idseguimiento_envio);
		System.out.println("seguimiento Envio eliminado..");
		return "/vistas/seguimientoEnvio/index.xhtml?faces-redirect=true";
		
	}

}
