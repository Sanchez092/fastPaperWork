package com.fastPaperWork.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fastPaperWork.DAO.RolDAO;
import com.fastPaperWork.DAO.UsuarioDAO;
import com.fastPaperWork.model.Rol;
import com.fastPaperWork.model.Usuario;

@ManagedBean(name = "rolBean")
@RequestScoped
@SessionScoped 
public class RolBean {
	
	Rol rol = new Rol();
	private List<Rol> obtenerRoles = new ArrayList<>();
	
	private int idusuario;
	
	public List<Usuario> listaUsuarios;
	
	public void llenarUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		this.listaUsuarios=usuarioDAO.obtenerUsuarios();
	}
	
	
	public RolBean() {
		this.llenarUsuarios();
	}
	

	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public String nuevo() {
		Rol r = new Rol();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("login", r);
		return "/vistas/Rol/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Rol rol) {
		RolDAO rolDAO =new RolDAO();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		rol.setIdusuario(usuario);
		usuario = usuarioDAO.buscar(idusuario);
		
		rolDAO.guardar(rol);
		return "/vistas/Rol/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Rol> obtenerRol(){
		RolDAO rolDAO =new RolDAO();
		return rolDAO.obtenerRol();
	}
	
	public String editar(int idrol) {
		RolDAO rolDAO =new RolDAO();
		Rol r = new Rol();
		r=rolDAO.buscar(idrol);
		System.out.println(r);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("rol", r);
		return "/vistas/Rol/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Rol rol) {
		RolDAO rolDAO =new RolDAO();
		rolDAO.editar(rol);
		return "/vistas/Rol/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idrol) {
		RolDAO rolDAO =new RolDAO();
		rolDAO.eliminar(idrol);
		System.out.println("Registro eliminado..");
		return "/vistas/Rol/index.xhtml?faces-redirect=true";
		
	}

	
	
}	
