package com.fastPaperWork.Controlador;


import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.fastPaperWork.DAO.LoginDAO;
import com.fastPaperWork.DAO.UsuarioDAO;
import com.fastPaperWork.model.Login;
import com.fastPaperWork.model.Usuario;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.fastPaperWork.utilities.ExportarExcel;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;


@ManagedBean(name = "usuarioBean")
@RequestScoped
@SessionScoped



public class UsuarioBean {
	
	Usuario usuario = new Usuario();
	private List<Usuario> obtenerUsuarios = new ArrayList<Usuario>();
	

	public String nuevo() {		
		Usuario u = new Usuario();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", u);
		return "/FormRegistro.xhtml?faces-redirect=true";
	}
	
	public String guardar(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.guardar(usuario);
		return "/formInisioS.xhtml?faces-redirect=true";
		
	}
	
	public List<Usuario> obtenerUsuarios(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.obtenerUsuarios();
		
	}
	
	public String editar(int id) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario u = new Usuario();
		u=usuarioDAO.buscar(id);
		System.out.println(u);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", u);
		return "/vistas/Usuario/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Usuario usuario) {
		 UsuarioDAO usuarioDAO = new UsuarioDAO();
		 usuarioDAO.editar(usuario);
		 return "/vistas/Usuario/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int id) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.eliminar(id);
		System.out.println("Usuario eliminado..");
		return "/vistas/Usuario/index.xhtml?faces-redirect=true";
		
	}
	
	public void exportar() throws IOException {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerkey = "Content-Disposition";
		String headerValue = "attachment; filename=listaUsuarios" + currentDateTime + ".xlsx";
		response.setHeader(headerkey, headerValue);
		System.out.println("usuario>" + usuario.toString());
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		this.obtenerUsuarios=usuarioDAO.obtenerUsuarios();
		
		ExportarExcel excelExportar = new ExportarExcel(this.obtenerUsuarios);
		excelExportar.export(response);
		
		
	}
	
	

}
