package com.fastPaperWork.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.fastPaperWork.DAO.AdministradorDAO;

import com.fastPaperWork.DAO.InventarioDAO;
import com.fastPaperWork.DAO.UsuarioDAO;
import com.fastPaperWork.model.Administrador;
import com.fastPaperWork.model.Inventario;
import com.fastPaperWork.model.Usuario;




@ManagedBean(name = "administradorBean")
@RequestScoped
@SessionScoped

public class AdministradorBean {
	
	Administrador administrador = new Administrador();
	private List<Administrador> obtenerAdministrador = new ArrayList<Administrador>();
	
	private int idinventario;
	
	public List<Inventario> listaInventario;	
	
	private int idusuario;
	
	public List<Usuario> listaUsuario;

	public void llenarInventario() {
		InventarioDAO inventarioDAO = new InventarioDAO();
		this.listaInventario=inventarioDAO.obtenerInventario();
	}
	
	public void llenarUsuario() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		this.listaUsuario=usuarioDAO.obtenerUsuarios();
	}
	
	
	public AdministradorBean() {
		this.llenarInventario();
		this.llenarUsuario();
	}


	public int getIdinventario() {
		return idinventario;
	}


	public void setIdinventario(int idinventario) {
		this.idinventario = idinventario;
	}


	public String nuevo() {
		Administrador a = new Administrador();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("administrador", a);
		return "/vistas/Administrador/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Administrador administrador) {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		
		InventarioDAO inventarioDAO = new InventarioDAO();
		Inventario inventario = new Inventario();
		administrador.setIdinventario(inventario);
		inventario = inventarioDAO.buscar(idinventario);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		administrador.setIdusuario(usuario);
		usuario = usuarioDAO.buscar(idusuario);
		
		administradorDAO.guardar(administrador);
		return "/vistas/Administrador/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Administrador> obtenerAdmin(){
		AdministradorDAO administradorDAO = new AdministradorDAO();
		return administradorDAO.obtenerAdmin();
		
	}
	
	public String editar(int idAdministrador) {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		Administrador a = new Administrador();
		a=administradorDAO.buscar(idAdministrador);
		System.out.println(a);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("administrador", a);
		return "/vistas/Administrador/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Administrador administrador) {
		 AdministradorDAO administradorDAO = new AdministradorDAO();
		 administradorDAO.editar(administrador);
		 return "/vistas/Administrador/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idAdministrador) {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		administradorDAO.eliminar(idAdministrador);
		System.out.println("Usuario eliminado..");
		return "/vistas/Administrador/index.xhtml?faces-redirect=true";
		
	}
	
}
