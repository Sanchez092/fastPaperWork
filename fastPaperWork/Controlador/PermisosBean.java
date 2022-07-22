package com.fastPaperWork.Controlador;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fastPaperWork.DAO.PermisosDAO;
import com.fastPaperWork.DAO.RolDAO;
import com.fastPaperWork.model.Permisos;
import com.fastPaperWork.model.Rol;

@ManagedBean(name = "permisosBean")
@RequestScoped
@SessionScoped 
public class PermisosBean {

	public String nuevo() {
		Permisos p = new Permisos();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("permisos", p);
		return "/vistas/Permisos/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Permisos permisos) {
		PermisosDAO permisosDAO = new PermisosDAO();
		permisosDAO.guardar(permisos);
		return "/vistas/Permisos/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Permisos> obtenerPermisos(){
		PermisosDAO permisosDAO = new PermisosDAO();
		return permisosDAO.obtenerPermisos();
	}
	
	public String editar(int idpermisos) {
		PermisosDAO permisosDAO = new PermisosDAO();
		Permisos p = new Permisos();
		p=permisosDAO.buscar(idpermisos);
		System.out.println(p);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("rol", p);
		return "/vistas/Permisos/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Permisos permisos) {
		PermisosDAO permisosDAO = new PermisosDAO();
		permisosDAO.editar(permisos);
		return "/vistas/Permisos/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idpermisos) {
		PermisosDAO permisosDAO = new PermisosDAO();
		permisosDAO.eliminar(idpermisos);
		System.out.println("Registro eliminado..");
		return "/vistas/Permisos/index.xhtml?faces-redirect=true";
		
	}
	
}
