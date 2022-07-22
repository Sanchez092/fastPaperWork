package com.fastPaperWork.Controlador;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import com.fastPaperWork.DAO.ProveedorDAO;
import com.fastPaperWork.model.Proveedor;
import javax.faces.context.FacesContext;

@ManagedBean(name = "proveedorBean")
@RequestScoped
@SessionScoped

public class ProveedorBean {
	
	
	
	public String nuevo() {
		Proveedor pr = new Proveedor();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", pr);
		return "/vistas/Proveedor/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Proveedor proveedor) {
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedorDAO.guardar(proveedor);
		return "/vistas/Proveedor/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Proveedor> obtenerProveedor(){
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		return proveedorDAO.obtenerProveedor();
		
	}
	
	public String editar(int idproveedor) {
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		Proveedor pr = new Proveedor();
		pr=proveedorDAO.buscar(idproveedor);
		System.out.println(pr);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", pr);
		return "/vistas/Proveedor/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Proveedor proveedor) {
		 ProveedorDAO proveedorDAO = new ProveedorDAO();
		 proveedorDAO.editar(proveedor);
		 return "/vistas/Proveedor/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idproveedor) {
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		proveedorDAO.eliminar(idproveedor);
		System.out.println("Proveedor eliminado..");
		return "/vistas/Proveedor/index.xhtml?faces-redirect=true";
		
	}
	 
}